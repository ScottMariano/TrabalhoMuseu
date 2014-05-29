/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.vo;

/**
 *
 * @author Viotti
 */
public class ObraVO {
    private int idObra,idTipo;
    private String Descricao, Texto1, Texto2, Proprietario;

    

    public ObraVO() 
    {
        
    }

    public ObraVO(int idObra, String Descricao, int idTipo, String Texto1, String Texto2, String Proprietario) 
    {
        this.setIdObra(idObra);
        this.setIdTipo(idTipo);
        this.setDescricao(Descricao);
        this.setTexto1(Texto1);
        this.setTexto2(Texto2);
        this.setProprietario(Proprietario);
    }

    /**
     * @return the idObra
     */
    public int getIdObra() {
        return idObra;
    }

    /**
     * @param idObra the idObra to set
     */
    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    /**
     * @return the idTipo
     */
    public int getIdTipo() {
        return idTipo;
    }

    /**
     * @param idTipo the idTipo to set
     */
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
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

    /**
     * @return the Texto1
     */
    public String getTexto1() {
        return Texto1;
    }

    /**
     * @param Texto1 the Texto1 to set
     */
    public void setTexto1(String Texto1) {
        this.Texto1 = Texto1;
    }

    /**
     * @return the Texto2
     */
    public String getTexto2() {
        return Texto2;
    }

    /**
     * @param Texto2 the Texto2 to set
     */
    public void setTexto2(String Texto2) {
        this.Texto2 = Texto2;
    }

    /**
     * @return the Proprietario
     */
    public String getProprietario() {
        return Proprietario;
    }

    /**
     * @param Proprietario the Proprietario to set
     */
    public void setProprietario(String Proprietario) {
        this.Proprietario = Proprietario;
    }

   
    
    
}
