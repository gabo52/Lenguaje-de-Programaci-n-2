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
import pe.edu.pucp.eventsoft.interfaces.DocenteDAO;
import pe.edu.pucp.eventsoft.model.Docente;
import pe.edu.pucp.eventsoft.model.Especialidad;

/**
 *
 * @author gabri
 */
public class DocenteMySQL extends UnicastRemoteObject implements DocenteDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public DocenteMySQL(int i) throws RemoteException {
        super(i);
    }
        
    @Override
    public ArrayList<Docente> listarPorCodigoPUCPNombreIdEspecialidad(String codigoPUCPNombre, int idEspecialidad) throws RemoteException {
        ArrayList<Docente> docentes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE_IDESPECIALIDAD(?,?)}");
            cs.setString("_codigo_PUCP_nombre", codigoPUCPNombre);
            cs.setInt("_id_especialidad", idEspecialidad);
            rs = cs.executeQuery();
            while(rs.next()){
                Docente docente = new Docente();
                
                docente.setIdDocente(rs.getInt("id_docente"));
                docente.setEspecialidad(new Especialidad());
                docente.getEspecialidad().setIdEspecialidad(rs.getInt("id_especialidad"));
                docente.getEspecialidad().setNombre(rs.getString("nombre_especialidad"));
                docente.setCodigoPUCP(rs.getString("codigo_PUCP"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellidoPaterno(rs.getString("apellido_paterno"));
                docente.setApellidoMaterno(rs.getString("apellido_materno"));
                docentes.add(docente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return docentes;
    }



    @Override
    public ArrayList<Docente> listarPorIdEvento(int idEvento) throws RemoteException {
                ArrayList<Docente> docentes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_DOCENTES_X_IDEVENTO(?)}");
            cs.setInt("_id_evento", idEvento);
            rs = cs.executeQuery();
            while(rs.next()){
                Docente docente = new Docente();
                docente.setIdDocente(rs.getInt("id_docente"));
                docente.setEspecialidad(new Especialidad());
                docente.getEspecialidad().setIdEspecialidad(rs.getInt("id_especialidad"));
                docente.getEspecialidad().setNombre(rs.getString("nombre_especialidad"));
                docente.setCodigoPUCP(rs.getString("codigo_PUCP"));
                docente.setNombre(rs.getString("nombre"));
                docente.setApellidoPaterno(rs.getString("apellido_paterno"));
                docente.setApellidoMaterno(rs.getString("apellido_materno"));
                docentes.add(docente);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return docentes;
    }
    
}
