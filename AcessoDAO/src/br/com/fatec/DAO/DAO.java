/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Viotti
 */
public interface DAO <tipoOBJ> {
    public void adicionar(tipoOBJ obj) throws SQLException,
                                                Exception;
    public void remover(tipoOBJ obj) throws SQLException,
                                                Exception;
    public void alterar(tipoOBJ obj) throws SQLException,
                                                Exception;
    public tipoOBJ buscar(tipoOBJ obj) throws SQLException,
                                                Exception;
    public List<tipoOBJ> lista(String criterio) throws SQLException,
                                                Exception;

    
}
