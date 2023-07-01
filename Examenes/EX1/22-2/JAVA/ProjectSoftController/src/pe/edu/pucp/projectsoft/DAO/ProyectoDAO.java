/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.projectsoft.DAO;

import java.util.ArrayList;
import pe.edu.pucp.projectsoft.model.Proyecto;

/**
 *
 * @author gabri
 */
public interface ProyectoDAO {
    int insertar(Proyecto proyecto);
    ArrayList<Proyecto> listarPorTituloCodigoPUCPNombre(String cadena);
}
