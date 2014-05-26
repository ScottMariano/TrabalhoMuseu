/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.vo;

/**
 *
 * @author Viotti
 */
public class FuncaoVO {
    private int idFuncao, Privilegio;
    private String Descricao;

    

    public FuncaoVO() 
    {
        
    }

    public FuncaoVO(int idFuncao, String Descricao, int Privilegio) 
    {
        this.setIdFuncao(idFuncao);
        this.setPrivilegio(Privilegio);
        this.setDescricao(Descricao);
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
     * @return the Privilegio
     */
    public int getPrivilegio() {
        return Privilegio;
    }

    /**
     * @param Privilegio the Privilegio to set
     */
    public void setPrivilegio(int Privilegio) {
        this.Privilegio = Privilegio;
    }

    /**
     * @return the Descricao
     */
    public String getDescricao() {
        return Descricao;
    }

    /**
     * @param Descricao the Descricao to set
     */
    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    
}
