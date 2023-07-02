/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.confesoft.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.confesoft.config.DBManager;
import pe.edu.pucp.confesoft.interfaces.EventoDAO;
import pe.edu.pucp.confesoft.model.Evento;
import pe.edu.pucp.confesoft.model.Ponencia;

/**
 *
 * @author gabri
 */
public class EventoMySQL  extends UnicastRemoteObject implements EventoDAO{

    
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    public EventoMySQL(int i) throws RemoteException {
        super(i);
    }

    @Override
    public int insertar(Evento evento) throws RemoteException {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_EVENTO(?,?,?,?,?)}");
            cs.registerOutParameter("_id_evento", java.sql.Types.INTEGER);
            cs.setString("_nombre", evento.getNombre());
            cs.setDate("_fecha", new java.sql.Date(evento.getFecha().getTime()));
            cs.setString("_descripcion", evento.getDescripcion());
            cs.setBytes("_portada", evento.getPortada());
            cs.executeUpdate();
            evento.setIdEvento(cs.getInt("_id_evento"));
            for(Ponencia ponencia : evento.getPonencias()){
                cs = con.prepareCall("{call INSERTAR_PONENCIA(?,?,?,?,?,?)}");
                cs.registerOutParameter("_id_ponencia", java.sql.Types.INTEGER);
                cs.setInt("_fid_evento", evento.getIdEvento());
                cs.setInt("_fid_ponente", ponencia.getPonente().getIdIntegrante());
                cs.setString("_titulo", ponencia.getTitulo());
                cs.setTime("_hora_inicio", ponencia.getHoraInicio());
                cs.setTime("_hora_fin", ponencia.getHoraFin());
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
            cs = con.prepareCall("{call LISTAR_EVENTO_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Evento evento = new Evento();
                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setNombre(rs.getString("nombre"));
                evento.setFecha(rs.getDate("fecha"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setPortada(rs.getBytes("portada"));
                evento.setActivo(rs.getBoolean("activo"));
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
