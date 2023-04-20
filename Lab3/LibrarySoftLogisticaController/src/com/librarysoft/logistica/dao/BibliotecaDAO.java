package com.librarysoft.logistica.dao;

import com.librarysoft.logistica.model.Biblioteca;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public interface BibliotecaDAO {
    //En el DAO solo se definen las clases a insertar
    public int insertar(Biblioteca biblioteca);
    public ArrayList<Biblioteca> listarTodas();
}
