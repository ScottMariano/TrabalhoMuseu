/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.vo;

import java.util.Calendar;

/**
 *
 * @author Viotti
 */
public class ExpedienteVO {
    private int idExpediente, Inteiras, Meias, idEvento;
    private Calendar Data;
    private EventoVO Evento;
    

    public ExpedienteVO() 
    {
        
    }

    public ExpedienteVO( int idExpediente, Calendar data,int Inteiras,int Meias, int idEvento) 
    {
        this.setIdExpediente(idExpediente);
        this.setInteiras(Inteiras);
        this.setMeias(Meias);
        this.setIdEvento(idEvento);
        this.setData(data);
        
    }

    /**
     * @return the idExpediente
     */
    public int getIdExpediente() {
        return idExpediente;
    }

    /**
     * @param idExpediente the idExpediente to set
     */
    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    /**
     * @return the Inteiras
     */
    public int getInteiras() {
        return Inteiras;
    }

    /**
     * @param Inteiras the Inteiras to set
     */
    public void setInteiras(int Inteiras) {
        this.Inteiras = Inteiras;
    }

    /**
     * @return the Meias
     */
    public int getMeias() {
        return Meias;
    }

    /**
     * @param Meias the Meias to set
     */
    public void setMeias(int Meias) {
        this.Meias = Meias;
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
     * @return the Evento
     */
    public EventoVO getEvento() {
        return Evento;
    }

    /**
     * @param Evento the Evento to set
     */
    public void setEvento(EventoVO Evento) {
        this.Evento = Evento;
    }

    /**
     * @return the Data
     */
    public Calendar getData() {
        return Data;
    }

    /**
     * @param Data the Data to set
     */
    public void setData(Calendar Data) {
        this.Data = Data;
    }

    
}
