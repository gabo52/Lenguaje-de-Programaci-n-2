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
import pe.edu.pucp.eventsoft.interfaces.EventoDAO;
import pe.edu.pucp.eventsoft.model.Actividad;
import pe.edu.pucp.eventsoft.model.Docente;
import pe.edu.pucp.eventsoft.model.Especialidad;
import pe.edu.pucp.eventsoft.model.Evento;

/**
 *
 * @author gabri
 */
public class EventoMySQL extends UnicastRemoteObject implements EventoDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public EventoMySQL(int puerto) throws RemoteException{
        super(puerto);
    }
    
    @Override
    public int insertar(Evento evento) throws RemoteException {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EVENTO(?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_evento", java.sql.Types.INTEGER);
            cs.setInt("_fid_especialidad", evento.getEspecialidad().getIdEspecialidad());
            cs.setString("_nombre", evento.getNombre());
            cs.setDate("_fecha_inicio", new java.sql.Date(evento.getFechaInicio().getTime()));
            cs.setDate("_fecha_fin", new java.sql.Date(evento.getFechaFin().getTime()));
            cs.setDouble("_costo", evento.getCosto());
            cs.setBytes("_foto", evento.getFoto());
            cs.executeUpdate();
            evento.setIdEvento(cs.getInt("_id_evento"));
            
            for(Docente docente : evento.getResponsables()){
                cs = con.prepareCall("{call INSERTAR_RESPONSABLE_EVENTO(?,?,?)}");
                cs.registerOutParameter("_id_responsable_evento", java.sql.Types.INTEGER);
                cs.setInt("_fid_docente", docente.getIdDocente());
                cs.setInt("_fid_evento", evento.getIdEvento());
                cs.executeUpdate();
            }
            
            for(Actividad actividad : evento.getActividades()){
                cs = con.prepareCall("{call INSERTAR_ACTIVIDAD_EVENTO(?,?,?,?,?,?)}");
                cs.registerOutParameter("_id_actividad", java.sql.Types.INTEGER);
                cs.setInt("_fid_evento", evento.getIdEvento());
                cs.setString("_nombre", actividad.getNombre());
                cs.setDate("_fecha",  new java.sql.Date(actividad.getFecha().getTime()));
                cs.setTime("_hora_inicio", actividad.getHoraInicio());
                cs.setTime("_hora_fin", actividad.getHoraFin());
                cs.executeUpdate();
            }
            
            resultado = evento.getIdEvento();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Evento> listarPorNombre(String nombre) throws RemoteException {
        ArrayList<Evento> eventos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EVENTOS_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Evento evento = new Evento();

                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setEspecialidad(new Especialidad());
                evento.getEspecialidad().setIdEspecialidad(rs.getInt("id_especialidad"));
                evento.getEspecialidad().setNombre(rs.getString("nombre_especialidad"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFechaInicio(rs.getDate("fecha_inicio"));
                evento.setFechaFin(rs.getDate("fecha_fin"));
                evento.setCosto(rs.getDouble("costo"));
                evento.setFoto(rs.getBytes("foto"));

                
                eventos.add(evento);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return eventos;
    }
    
}
