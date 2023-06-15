/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.cinemasoft.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.cinemasoft.config.DBManager;
import pe.edu.pucp.cinemasoft.dao.ActorDAO;
import pe.edu.pucp.cinemasoft.model.Actor;

/**
 *
 * @author gabri
 */
public class ActorMySQL implements ActorDAO{

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public ArrayList<Actor> listarPorNombre(String nombre) {
            ArrayList<Actor> actores = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ACTORES_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Actor actor = new Actor();
                actor.setIdActor(rs.getInt("id_actor"));
                actor.setApellidoPaterno(rs.getString("apellido_paterno"));
                actor.setNacionalidad(rs.getString("nacionalidad"));
                actor.setNombre(rs.getString("nombre"));
                actor.setActivo(true);
                actores.add(actor);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return actores;
    }

    @Override
    public ArrayList<Actor> listarPorIdPelicula(int idPelicula) {
        ArrayList<Actor> actores = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ACTORES_X_ID_PELICULA(?)}");
            cs.setInt("_id_pelicula", idPelicula);
            rs = cs.executeQuery();
            while(rs.next()){
                Actor actor = new Actor();
                
                actor.setIdActor(rs.getInt("id_actor"));
                actor.setNombre(rs.getString("nombre"));
                actor.setApellidoPaterno(rs.getString("apellido_paterno"));
                actor.setNacionalidad(rs.getString("nacionalidad"));
                
                actores.add(actor);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return actores;
    }
    
}
