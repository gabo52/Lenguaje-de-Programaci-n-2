/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ingesoft.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.ingesoft.config.DBManager;
import pe.edu.pucp.ingesoft.interfaces.EspecialidadDAO;
import pe.edu.pucp.ingesoft.model.Especialidad;

public class EspecialidadMySQL extends UnicastRemoteObject implements EspecialidadDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public EspecialidadMySQL(int puerto) throws RemoteException{
        super(puerto);
    }
        
    @Override
    public ArrayList<Especialidad> listarTodas() throws RemoteException {
        ArrayList<Especialidad> especialidades = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_TODAS_ESPECIALIDADES()}");
            rs=cs.executeQuery();
            while(rs.next()){
                
                Especialidad especialidad = new Especialidad();
                especialidad.setIdEspecialidad(rs.getInt("id_especialidad"));
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setActivo(true);
                
                especialidades.add(especialidad);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return especialidades;
    }
    
}
