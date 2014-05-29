/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.FuncionarioVO;
import br.com.fatec.vo.LoginVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viotti
 */
public class FuncionarioDAO implements DAO <FuncionarioVO>{

    //Contem o comando em SQL
    private Statement st = null;
    //Contem o resultado de um SELECT
    private ResultSet rs = null;
    private String sql = null;
    //Contem a conexao com o Banco
    private BancoFactory bf = null;
    //Auxiliar para ClienteVO
    private FuncionarioVO funcionario = null;
    
    /**
     * Construtor que recebe o banco já conectado
     * @param bf 
     */
    public FuncionarioDAO(BancoFactory bf){
        this.bf = bf;
    }
    
    /**
     * Inclui um registro na tabela de Clientes
     * @param obj - Dados do cliente
     * @throws SQLException - Erro de SQL
     * @throws Exception - Erro interno no método
     */
    @Override
    public void adicionar(FuncionarioVO obj) throws SQLException, Exception {
        sql = "insert into funcionarios (idFuncao, cpf, nome, telefone , endereco, email ) values (" +
                obj.getIdFuncao()+ ", '" + obj.getCPF() + "' ,'" + obj.getNome() + "' ,'" + obj.getTelefone() + "' ,'" +
                "', '" + obj.getEndereco()+ "', '" + obj.getEmail()+ "')";
        
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Incluiu o Funcionario");
        } else
            bf.getConexao().close(); //fecha a conexao
    }

    @Override
    public void remover(FuncionarioVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(FuncionarioVO obj) throws SQLException, Exception {
        
        obj = buscar(obj);
        
                  sql = "UPDATE funcionarios SET cpf = '" + obj.getCPF()
                 +  "', nome = '" + obj.getNome()
                 +  "' endereco = '" + obj.getEndereco()
                 +  "' email '= " + obj.getEmail();
                  sql += "' where idFuncionario = " + obj.getIdFuncionario();
              
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Alterou expediente");
        } else
            bf.getConexao().close(); //fecha a conexao
        
        
    }

    @Override
    public FuncionarioVO buscar(FuncionarioVO obj) throws SQLException, Exception {
         sql = "select * from funcionarios where ";
        
        if(obj.getIdFuncionario() > 0)
            sql += "idFuncionario = " + obj.getIdFuncionario() + " | ";  
        if(obj.getIdFuncao()> 0)
            sql += "idFuncao = " + obj.getIdFuncao() + " | ";
        if(!obj.getCPF().isEmpty())
            sql += "CPF like '" + obj.getCPF()+ "' | ";
        if(!obj.getNome().isEmpty())
            sql += "Nome like '" + obj.getNome()+ "%' | ";
        if(!obj.getTelefone().isEmpty())
            sql += "Telefone like '" + obj.getTelefone()+ "' | ";
        if(!obj.getEndereco().isEmpty())
            sql += "Endereco like '" + obj.getEndereco()+ "' | ";
          if(!obj.getEmail().isEmpty())
            sql += "Email like '" + obj.getEmail()+ "' | ";
                    
        if(sql.contains("|"))
            sql = sql.substring(0, sql.length()-2);
              
          sql = sql.replace("|", "AND");
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
                return new FuncionarioVO(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7));
        } 
        else
        {
            return null;
        }
    }

    @Override
    public List<FuncionarioVO> lista(String criterio) throws SQLException, Exception {
       if(criterio.isEmpty())
            sql = "select * from funcionarios";
        else
            sql = "select * from funcionarios where " + criterio;
        
        
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        List<FuncionarioVO> listaFuncionarios = new ArrayList();
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            do
                listaFuncionarios.add(new FuncionarioVO(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7)));
            while(rs.next());
        } 
        else
        {
            return null;
        }
        
        return listaFuncionarios;
    }
    
}





