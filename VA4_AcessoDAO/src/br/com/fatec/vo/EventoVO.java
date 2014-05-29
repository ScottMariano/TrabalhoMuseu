/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.vo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Viotti
 */
public class EventoVO {
    private int idEvento,MaxEntradas;
    private String Descricao, Texto1, Texto2;
    private Calendar DataInicio, DataFinal;
    private ArrayList<ObraVO> Obras;

    public EventoVO() 
    {
        
    }

    public EventoVO(int idEvento, String Descricao, String Texto1, String Texto2, Calendar DataInicio, Calendar DataFinal, int MaxEntradas) 
    {
        this.setIdEvento(idEvento);
        this.setMaxEntradas(MaxEntradas);
        this.setDescricao(Descricao);
        this.setTexto1(Texto1);
        this.setTexto2(Texto2);
        this.setDataInicio(DataInicio);
        this.setDataFinal(DataFinal);
    }

    
    public int addObra() 
    {
        return idEvento;
    }

   
    public ObraVO[] getObras() 
    {
        return Obras.toArray(new ObraVO[Obras.size()]);
    }
    
    public ObraVO getObraById(int idObra) 
    {
        for(ObraVO o : getObras())
            if(o.getIdObra() == idObra)
                return o;
        return null;
    }
        
    /**
     * @return the idEvento
     */
    public int getIdEvento() {
        return idEvento;
    }

    /**
     * @param idEvento the idEvento to set
     */
    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    /**
     * @return the MaxEntradas
     */
    public int getMaxEntradas() {
        return MaxEntradas;
    }

    /**
     * @param MaxEntradas the MaxEntradas to set
     */
    public void setMaxEntradas(int MaxEntradas) {
        this.MaxEntradas = MaxEntradas;
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
     * @return the DataInicio
     */
    public Calendar getDataInicio() {
        return DataInicio;
    }

    /**
     * @param DataInicio the DataInicio to set
     */
    public void setDataInicio(Calendar DataInicio) {
        this.DataInicio = DataInicio;
    }

    /**
     * @return the DataFinal
     */
    public Calendar getDataFinal() {
        return DataFinal;
    }

    /**
     * @param DataFinal the DataFinal to set
     */
    public void setDataFinal(Calendar DataFinal) {
        this.DataFinal = DataFinal;
    }

    /**
     * @param Obras the Obras to set
     */
    public void setObras(ArrayList<ObraVO> Obras) {
        this.Obras = Obras;
    }

    
    
}
