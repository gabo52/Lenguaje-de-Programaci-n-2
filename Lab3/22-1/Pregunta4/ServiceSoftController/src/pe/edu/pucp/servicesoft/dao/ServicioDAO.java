/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.servicesoft.dao;

import java.util.ArrayList;
import pe.edu.servicesoft.model.Servicio;

/**
 *
 * @author gabri
 */
public interface ServicioDAO {
    public int insertar(Servicio servicio);
    public ArrayList<Servicio> listarTodos();
}
