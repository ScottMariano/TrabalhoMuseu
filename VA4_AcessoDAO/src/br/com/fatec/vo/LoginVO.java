/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.vo;

/**
 *
 * @author Viotti
 */
public class LoginVO {
    private int idLogin;
    private String Login,Senha;
    private boolean Ativo;

    

    public LoginVO() 
    {
        
    }

    public LoginVO(int idLogin, String Login, String Senha,boolean Ativo) 
    {
        this.setIdLogin(idLogin);
        this.setLogin(Login);
        this.setSenha(Senha);
        this.setAtivo(Ativo);
    }

    /**
     * @return the idLogin
     */
    public int getIdLogin() {
        return idLogin;
    }

    /**
     * @param idLogin the idLogin to set
     */
    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    /**
     * @return the Login
     */
    public String getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(String Login) {
        this.Login = Login;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    /**
     * @return the Ativo
     */
    public boolean isAtivo() {
        return Ativo;
    }

    /**
     * @param Ativo the Ativo to set
     */
    public void setAtivo(boolean Ativo) {
        this.Ativo = Ativo;
    }

    
    
}
