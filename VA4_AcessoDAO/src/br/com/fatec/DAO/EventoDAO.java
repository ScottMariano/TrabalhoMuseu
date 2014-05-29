/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.EventoVO;
import br.com.fatec.vo.FuncionarioVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Viotti
 */
public class EventoDAO implements DAO <EventoVO>{

    //Contem o comando em SQL
    private Statement st = null;
    //Contem o resultado de um SELECT
    private ResultSet rs = null;
    private String sql = null;
    //Contem a conexao com o Banco
    private BancoFactory bf = null;
    //Auxiliar para ClienteVO
    private EventoVO evento = null;
    
    /**
     * Construtor que recebe o banco já conectado
     * @param bf 
     */
    public EventoDAO(BancoFactory bf){
        this.bf = bf;
    }
    
    /**
     * Inclui um registro na tabela de Clientes
     * @param obj - Dados do cliente
     * @throws SQLException - Erro de SQL
     * @throws Exception - Erro interno no método
     */
    @Override
    public void adicionar(EventoVO obj) throws SQLException, Exception {
        sql = "insert into evento (Descricao , Texto1, Texto2, DataInicio, DataFinal, MaxEntradasDia) values ('" +
                obj.getDescricao() + "', '" + obj.getTexto1() + "', '" + obj.getTexto2() + "', '" +
                obj.getDataInicio().get(Calendar.YEAR) + "-" +  obj.getDataInicio().get(Calendar.MONTH) + "-" + obj.getDataInicio().get(Calendar.DAY_OF_MONTH) + "', '" +
                obj.getDataFinal().get(Calendar.YEAR) + "-" +  obj.getDataFinal().get(Calendar.MONTH) + "-" + obj.getDataFinal().get(Calendar.DAY_OF_MONTH)+
                "', " + obj.getMaxEntradas() + ")";
                
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Incluiu o Evento");
        } else
            bf.getConexao().close(); //fecha a conexao
    }

    @Override
    public void remover(EventoVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(EventoVO obj) throws SQLException, Exception {
       
        if(buscar(obj) == null)
            adicionar(obj);
        else
        {
           sql = "UPDATE evento SET Descricao = '" + obj.getDescricao()
                 +  "', Texto1 = '" + obj.getTexto1()
                 +  "' Texto2 = '" + obj.getTexto2()
                 +  "' DataInicio '= " + obj.getDataInicio().get(Calendar.YEAR)+ "-" +  (obj.getDataInicio().get(Calendar.MONTH) + 1) + "-" + obj.getDataInicio().get(Calendar.DAY_OF_MONTH)
                 +  "' DataFinal '= " + obj.getDataFinal().get(Calendar.YEAR)+ "-" +  (obj.getDataFinal().get(Calendar.MONTH) + 1) + "-" + obj.getDataFinal().get(Calendar.DAY_OF_MONTH)
                 +  "' MaxEntradasDia = " + obj.getMaxEntradas();
                           
          sql += " where idEvento = " + obj.getIdEvento();
              
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Alterou expediente");
        } else
            bf.getConexao().close(); //fecha a conexao
        }
        
        
    }

    @Override
    public EventoVO buscar(EventoVO obj) throws SQLException, Exception {
        
         sql = "select * from evento where ";
        
         if(obj.getIdEvento()> 0)
            sql += "idEvento = " + obj.getIdEvento();
         else
         {  
        if(!obj.getDescricao().isEmpty())
            sql += "Descricao = '" + obj.getDescricao()+ "' | ";
         }
                    
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
            
            return new EventoVO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),getCalendar(rs.getString(5)),getCalendar(rs.getString(6)), rs.getInt(7));
        } 
        else
        {
            return null;
        }
        
        
    }

    public EventoVO buscarData(String DataSQL) throws Exception 
    {
        //só retorna o primeiro
        List<EventoVO> ev = this.lista(" DATEDIFF('"+DataSQL+"',DataInicio) > 0 and DATEDIFF('" + DataSQL + "',DataFinal) < 0 ");
        if(ev != null && !ev.isEmpty())
            return ev.get(0);
        else
            return null;
    }
    
    @Override
    public List<EventoVO> lista(String criterio) throws SQLException, Exception {
        if(criterio.isEmpty())
            sql = "select * from evento";
        else
            sql = "select * from evento where " + criterio;
        
        
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        List<EventoVO> listaEvento = new ArrayList();
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            do
                listaEvento.add(new EventoVO(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),getCalendar(rs.getString(5)),getCalendar(rs.getString(6)), rs.getInt(7)));
            while(rs.next());
        } 
        else
        {
            return null;
        }
        
        return listaEvento;
    }
    
    
    public Calendar getCalendar(String data) {
    Calendar date = Calendar.getInstance();
    date.set(Calendar.YEAR, Integer.parseInt(data.split("-")[0]));
    date.set(Calendar.MONTH, Integer.parseInt(data.split("-")[1]));
    date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data.split("-")[2]));

    return date;
}



    
}





