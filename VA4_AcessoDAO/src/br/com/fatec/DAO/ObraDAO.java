/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import br.com.fatec.banco.BancoFactory;
import br.com.fatec.vo.EventoVO;
import br.com.fatec.vo.ObraVO;
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
public class ObraDAO implements DAO <ObraVO>{

    //Contem o comando em SQL
    private Statement st = null;
    //Contem o resultado de um SELECT
    private ResultSet rs = null;
    private String sql = null;
    //Contem a conexao com o Banco
    private BancoFactory bf = null;
    //Auxiliar para ClienteVO
    private ObraVO Obra = null;
    
    /**
     * Construtor que recebe o banco já conectado
     * @param bf 
     */
    public ObraDAO(BancoFactory bf){
        this.bf = bf;
    }
    
    /**
     * Inclui um registro na tabela de Clientes
     * @param obj - Dados do cliente
     * @throws SQLException - Erro de SQL
     * @throws Exception - Erro interno no método
     */
    @Override
    public void adicionar(ObraVO obj) throws SQLException, Exception {
        sql = "insert into obra (Descricao , idTipo, Texto2, Texto2, Proprietario) values ('" +
                obj.getDescricao() + "', " + obj.getIdTipo()+", '" +  obj.getTexto1() + "', '" + obj.getTexto2() + "', '" +
                obj.getProprietario() + "')";
                
        //Criar o statement e abrir a conexao com o banco
        st = bf.getConexao().createStatement();
        if(st.executeUpdate(sql) == 0) { //nao afetou ninguem
            bf.getConexao().close();
            throw new Exception("Não Incluiu a Obra");
        } else
            bf.getConexao().close(); //fecha a conexao
    }

    @Override
    public void remover(ObraVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(ObraVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ObraVO buscar(ObraVO obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ObraVO> lista(String criterio) throws SQLException, Exception {
               if(criterio.isEmpty())
            sql = "select * from obra";
        else
            sql = "select * from obra where " + criterio;
        
        
        st = bf.getConexao().createStatement();
        rs = st.executeQuery(sql);
        List<ObraVO> listaEvento = new ArrayList();
        if(rs.next()) 
        { 
            //existe
            bf.getConexao().close();
            do
                listaEvento.add(new ObraVO(rs.getInt(0), rs.getString(1), rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
            while(rs.next());
        } 
        else
        {
            return null;
        }
        
        return listaEvento;
    }
    
}





