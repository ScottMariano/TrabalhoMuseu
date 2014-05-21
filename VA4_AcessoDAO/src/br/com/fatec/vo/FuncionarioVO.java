/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.vo;

/**
 *
 * @author Viotti
 */
public class FuncionarioVO {
    private int idFuncionario;
    private int idFuncao;
    private String CPF;
    private String Nome;
    private String Telefone;
    private String Endereco;
    private String Email;
    private LoginVO Login;
    private FuncaoVO Funcao;

    public FuncionarioVO(int idFuncionario, int idFuncao, String CPF, String Nome, String Telefone, String Endereco, String Email) {
        
        this.setIdFuncionario(idFuncionario);
        this.setIdFuncao(idFuncao);
        this.setCPF(CPF);
        this.setNome(Nome);
        this.setTelefone(Telefone);
        this.setEndereco(Endereco);
        this.setEmail(Email);
    }

    public void FuncionarioVO()
    {
    
    }  
    
 
    
    
    /**
     * @return the idFuncionario
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the idFuncao
     */
    public int getIdFuncao() {
        return idFuncao;
    }

    /**
     * @param idFuncao the idFuncao to set
     */
    public void setIdFuncao(int idFuncao) {
        this.idFuncao = idFuncao;
    }

    /**
     * @return the CPF
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * @param CPF the CPF to set
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return Nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * @return the Telefone
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     * @param Telefone the Telefone to set
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     * @return the Endereco
     */
    public String getEndereco() {
        return Endereco;
    }

    /**
     * @param Endereco the Endereco to set
     */
    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the Funcao
     */
    public FuncaoVO getFuncao() {
        return Funcao;
    }

    /**
     * @param Funcao the Funcao to set
     */
    public void setFuncao(FuncaoVO Funcao) {
        this.Funcao = Funcao;
    }

    /**
     * @return the Login
     */
    public LoginVO getLogin() {
        return Login;
    }

    /**
     * @param Login the Login to set
     */
    public void setLogin(LoginVO Login) {
        this.Login = Login;
    }

   
   
    
    
}
