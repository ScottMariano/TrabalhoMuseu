/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Viotti
 */
public class BancoFactory {
    private String servidor, banco, usuario, senha;
    private int porta;
    //Variavel de conexao
    private Connection con;

    /**
     * Devolve uma conexao para o usuário
     * @return conexao
     */
    public Connection getConexao() 
            throws ClassNotFoundException, SQLException {
        String url;
        url = "jdbc:mysql://" + getServidor() + ":" +
                getPorta() + "/" + getBanco();
        //carrega o Driver
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, getUsuario(),
                getSenha());
        return con;
    }
    
    public BancoFactory() {
    }

    public BancoFactory(String servidor, String banco, String usuario, String senha, int porta) {
        this.servidor = servidor;
        this.banco = banco;
        this.usuario = usuario;
        this.senha = senha;
        this.porta = porta;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    
}
