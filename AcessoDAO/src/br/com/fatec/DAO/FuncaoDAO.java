/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.FuncaoVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viotti
 */
public class FuncaoDAO implements DAO <FuncaoVO>{

    //Contem o comando em SQL
    private Statement st = null;
    //Contem o resultado de um SELECT
    private ResultSet rs = null;
    private String sql = null;
    //Contem a conexao com o Banco
    private BancoFactory bf = null;
    //Auxiliar para ClienteVO
    private FuncaoVO cli = null;
    
    /**
     * Construtor que recebe o banco já conectado
     * @param bf 
     */
    public FuncaoDAO(BancoFactory bf){
        this.bf = bf;
    }
    
    /**
     * Inclui um registro na tabela de Clientes
     * @param obj - Dados do cliente
     * @throws SQLException - Erro de SQL
     * @throws Exception - Erro interno no método
     */
    @Override
    public void adicionar(FuncaoVO obj) throws SQLException, Exception {
        sql = "insert into funcao (descricao, privilegio) values ( " +
                "'" + obj.getDescricao()+"' , " + obj.getPrivilegio()+ " )";
        
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Incluiu a funcao");
        } else
            bf.getConexao().close(); //fecha a conexao
    }

    @Override
    public void remover(FuncaoVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(FuncaoVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public FuncaoVO buscar(FuncaoVO obj) throws SQLException, Exception {
        sql = "select * from funcao where ";
        
        if(obj.getIdFuncao() > 0)
            sql += "idFincao = " + obj.getIdFuncao() + " | ";
        if(!obj.getDescricao().isEmpty())
            sql += "Descricao like " + obj.getDescricao()+ " | ";
        if(obj.getPrivilegio() > -1)
            sql += "Privilegio = " + obj.getPrivilegio() + " | ";
                    
        if(sql.contains("|"))
            sql = sql.substring(0, sql.length()-1);
              
          sql = sql.replace("|", "AND");
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            return new FuncaoVO(rs.getInt(0), rs.getString(1), rs.getInt(2));
        } 
        else
        {
            return null;
        }
    }

    @Override
    public List<FuncaoVO> lista(String criterio) throws SQLException, Exception {
               
        if(criterio.isEmpty())
            sql = "select * from funcao";
        else
            sql = "select * from funcao where " + criterio;
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        List<FuncaoVO> listaFuncao = new ArrayList();
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            do
                listaFuncao.add(new FuncaoVO(rs.getInt(0), rs.getString(1), rs.getInt(2)));
            while(rs.next());
        } 
        else
        {
            return null;
        }
        
        return listaFuncao;
    }
    
}





