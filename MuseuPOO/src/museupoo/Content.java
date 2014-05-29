/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package museupoo;

import br.com.fatec.DAO.EventoDAO;
import br.com.fatec.DAO.ExpedienteDAO;
import br.com.fatec.DAO.FuncaoDAO;
import br.com.fatec.DAO.FuncionarioDAO;
import br.com.fatec.DAO.LoginDAO;
import br.com.fatec.DAO.ObraDAO;
import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.EventoVO;
import br.com.fatec.vo.ExpedienteVO;
import br.com.fatec.vo.FuncionarioVO;
import java.sql.Connection;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor
 */
public class Content 
{
   public EventoDAO eventoDAO;
   public ExpedienteDAO expedienteDAO;
   public FuncaoDAO funcaoDAO;
   public FuncionarioDAO funcionarioDAO;
   public LoginDAO loginDAO;
   public ObraDAO obraDAO;
   public Connection conexao = null;
   public BancoFactory bf;
        
    
   private FuncionarioVO FuncionarioAtual;
   private EventoVO EventoAtual;
   
   
   private ExpedienteVO ExpedienteAtual;
   private Calendar DataSelecionada;
   
    public Content(BancoFactory bf)
    {
        this.bf = bf;
        eventoDAO = new EventoDAO(bf);
        expedienteDAO = new ExpedienteDAO(bf);
        funcaoDAO = new FuncaoDAO(bf);
        funcionarioDAO = new FuncionarioDAO(bf);
        loginDAO = new LoginDAO(bf);
        obraDAO = new ObraDAO(bf);
         
    }

    /**
     * @return the FuncionarioAtual
     */
    public FuncionarioVO getFuncionarioAtual() {
        return FuncionarioAtual;
    }

    /**
     * @param FuncionarioAtual the FuncionarioAtual to set
     */
    public void setFuncionarioAtual(FuncionarioVO FuncionarioAtual) {
        this.FuncionarioAtual = FuncionarioAtual;
    }

    /**
     * @return the EventoAtual
     */
    public EventoVO getEventoAtual() {
        return EventoAtual;
    }

    /**
     * @param EventoAtual the EventoAtual to set
     */
    public void setEventoAtual(EventoVO EventoAtual) {
        this.EventoAtual = EventoAtual;
    }

    /**
     * @return the ExpedienteAtual
     */
    public ExpedienteVO getExpedienteAtual() 
    {
        return ExpedienteAtual;
    }

    /**
     * @param ExpedienteAtual the ExpedienteAtual to set
     */
    public void setExpedienteAtual(ExpedienteVO ExpedienteAtual) 
    {
     try 
     {
              
        if(ExpedienteAtual != null && ExpedienteAtual.getIdEvento() > 0)
          
         expedienteDAO.alterar(ExpedienteAtual);
        
       
          
        this.ExpedienteAtual = ExpedienteAtual;
        if(ExpedienteAtual != null && ExpedienteAtual.getIdEvento() > 0)
            expedienteDAO.alterar(ExpedienteAtual); 
     } catch (Exception ex) 
        {
            Logger.getLogger(Content.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Calendar getDataSelecionada() 
    {
        return DataSelecionada;
    }

    /**
     * @param DataSelecionada the DataSelecionada to set
     */
    public void setDataSelecionada(Calendar DataSelecionada) {
        this.DataSelecionada = DataSelecionada;
    }
    
    
}
