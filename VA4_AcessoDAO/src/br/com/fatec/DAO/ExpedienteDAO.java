/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.EventoVO;
import br.com.fatec.vo.ExpedienteVO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Viotti
 */
public class ExpedienteDAO implements DAO <ExpedienteVO>{

    //Contem o comando em SQL
    private Statement st = null;
    //Contem o resultado de um SELECT
    private ResultSet rs = null;
    private String sql = null;
    //Contem a conexao com o Banco
    private BancoFactory bf = null;
    //Auxiliar para ClienteVO
    private ExpedienteVO expediente = null;
    
    /**
     * Construtor que recebe o banco já conectado
     * @param bf 
     */
    public ExpedienteDAO(BancoFactory bf){
        this.bf = bf;
    }
    
    /**
     * Inclui um registro na tabela de Clientes
     * @param obj - Dados do cliente
     * @throws SQLException - Erro de SQL
     * @throws Exception - Erro interno no método
     */
    @Override
    public void adicionar(ExpedienteVO obj) throws SQLException, Exception {
        sql = "insert into cliente (Data , idEvento, Meia, Inteira) values ('" +
                obj.getData().get(Calendar.YEAR) + "-" +  obj.getData().get(Calendar.MONTH) + "-" + obj.getData().get(Calendar.DAY_OF_MONTH) +
                "' , " + obj.getIdEvento() + " , " + obj.getMeias() + "  , " + obj.getInteiras()+ ")" ;
        
        
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Incluiu o Expediente");
        } else
            bf.getConexao().close(); //fecha a conexao
    }

    @Override
    public void remover(ExpedienteVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(ExpedienteVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ExpedienteVO buscar(ExpedienteVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ExpedienteVO> lista(String criterio) throws SQLException, Exception {
          if(criterio.isEmpty())
            sql = "select * from evento";
        else
            sql = "select * from evento where " + criterio;
        
        
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        List<ExpedienteVO> listaEvento = new ArrayList();
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            do
                listaEvento.add(new ExpedienteVO(rs.getInt(0), getCalendar(rs.getString(1)), rs.getInt(2),rs.getInt(3),rs.getInt(4)));
            while(rs.next());
        } 
        else
        {
            return null;
        }
        
        return listaEvento;
        
    }
    
      
    public Calendar getCalendar(String data) 
    {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, Integer.parseInt(data.substring(0, 4)));
        date.set(Calendar.MONTH, Integer.parseInt(data.substring(5, 2)));
        date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data.substring(7, 2)));

        return date;
    }
    
}





