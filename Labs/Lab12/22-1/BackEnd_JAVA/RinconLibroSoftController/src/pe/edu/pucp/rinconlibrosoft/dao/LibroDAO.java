/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.rinconlibrosoft.dao;

import java.util.ArrayList;
import pe.edu.pucp.rinconlibrosoft.model.Libro;

/**
 *
 * @author gabri
 */
public interface LibroDAO {
    int insertar(Libro libro);
    ArrayList<Libro>listarPorTituloOEditorial(String tituloOEditorial);
}
