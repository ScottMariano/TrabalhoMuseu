/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.FuncaoVO;
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
public class LoginDAO implements DAO <LoginVO>{

    //Contem o comando em SQL
    private Statement st = null;
    //Contem o resultado de um SELECT
    private ResultSet rs = null;
    private String sql = null;
    //Contem a conexao com o Banco
    private BancoFactory bf = null;
    //Auxiliar para ClienteVO
    private LoginVO login = null;
    
    /**
     * Construtor que recebe o banco já conectado
     * @param bf 
     */
    public LoginDAO(BancoFactory bf){
        this.bf = bf;
    }
    
    /**
     * Inclui um registro na tabela de Clientes
     * @param obj - Dados do cliente
     * @throws SQLException - Erro de SQL
     * @throws Exception - Erro interno no método
     */
    @Override
    public void adicionar(LoginVO obj) throws SQLException, Exception {
        sql = "insert into login ( Login, Senha, Ativo ) values (" +
                obj.getLogin()+ ", '" + obj.getSenha() + 
                "', 1)";
        
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Incluiu o Login");
        } else
            bf.getConexao().close(); //fecha a conexao
    }

    @Override
    public void remover(LoginVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(LoginVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public LoginVO buscar(LoginVO obj) throws SQLException, Exception {
        sql = "select * from login where ";
        
        if(obj.getIdFuncionario()> 0)
            sql += "idFuncionario = " + obj.getIdFuncionario() + " | ";
        if(!obj.getLogin().isEmpty())
            sql += "Descricao like " + obj.getLogin()+ " | ";
          if(!obj.getLogin().isEmpty())
            sql += "Descricao like " + obj.getSenha()+ " | ";
        if(obj.isAtivo())
            sql += "Privilegio = 1";
                    
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
                return new LoginVO(rs.getInt(0), rs.getString(1), rs.getString(2), rs.getBoolean(3));
        } 
        else
        {
            return null;
        }
    }

    @Override
    public List<LoginVO> lista(String criterio) throws SQLException, Exception {
       
        if(criterio == "")
            sql = "select * from login";
        else
            sql = "select * from login where " + criterio;
        
        
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        List<LoginVO> listaLogin = new ArrayList();
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            do
                listaLogin.add(new LoginVO(rs.getInt("idFuncionario"), rs.getString("Login"), rs.getString("Senha"), rs.getBoolean("Ativo")));
            while(rs.next());
        } 
        else
        {
            return null;
        }
        
        return listaLogin;
        
    }
    
}





