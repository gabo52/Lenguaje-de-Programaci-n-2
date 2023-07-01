/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.eventsoft.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.eventsoft.config.DBManager;
import pe.edu.pucp.eventsoft.interfaces.ActividadDAO;
import pe.edu.pucp.eventsoft.model.Actividad;

/**
 *
 * @author gabri
 */
public class ActividadMySQL extends UnicastRemoteObject implements ActividadDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public ActividadMySQL(int i) throws RemoteException {
        super(i);
    }
    
    @Override
    public ArrayList<Actividad> listarPorIdEvento(int idEvento) throws RemoteException {
        ArrayList<Actividad> actividades = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ACTIVIDADES_X_IDEVENTO(?)}");
            cs.setInt("_id_evento", idEvento);
            rs = cs.executeQuery();
            while(rs.next()){
                Actividad actividad = new Actividad();
                actividad.setIdActividad(rs.getInt("id_actividad"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setFecha(rs.getDate("fecha"));
                actividad.setHoraInicio(rs.getTime("hora_inicio"));
                actividad.setHoraFin(rs.getTime("hora_fin"));
                actividades.add(actividad);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return actividades;
    }
    
}
