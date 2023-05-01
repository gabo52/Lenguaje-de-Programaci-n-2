/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.servicesoft.main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.servicesoft.dao.ServicioDAO;
import pe.edu.pucp.servicesoft.mysql.ServicioMySQL;
import pe.edu.servicesoft.model.Servicio;

/**
 *
 * @author gabri
 */
public class Principal {
    public static void main(String[] args) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Servicio serv1 = new Servicio("Reparación de PC",
        "La oficina de RRHH ha solicitado la reparación de una computadora",
        200.00,5,sdf.parse("10-05-2022"),'P');
        Servicio serv2 = new Servicio("Mantenimiento de Servidores",
        "La facultad de Ciencias e Ingeniería solicitó el mes pasado un mantenimiento de servidores",
        500.23,3,sdf.parse("01-04-2022"),'D');
        ServicioDAO daoServicio = new ServicioMySQL();
        daoServicio.insertar(serv1);
        daoServicio.insertar(serv2);
        ArrayList<Servicio> servicios = daoServicio.listarTodos();
        for(Servicio serv : servicios){
            System.out.println(serv.getIdServicio() + ". " + serv.getNombre() + ": " + 
            sdf.format(serv.getFecha()) + " - S/. " + serv.getCosto() + " - " + 
            serv.getEstado());
       }
    }
}
