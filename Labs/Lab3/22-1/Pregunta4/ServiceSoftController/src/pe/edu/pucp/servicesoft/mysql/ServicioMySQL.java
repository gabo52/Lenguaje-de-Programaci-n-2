/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.servicesoft.mysql;

import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import pe.edu.pucp.servicesoft.config.DBManager;
import pe.edu.pucp.servicesoft.dao.ServicioDAO;
import pe.edu.servicesoft.model.Servicio;

/**
 *
 * @author gabri
 */
public class ServicioMySQL implements ServicioDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    @Override
    public int insertar(Servicio servicio) {
        int resultado=0;
        Time time;
        try{
            con = DBManager.getInstance().getConnection();
            //Instruccion SQL
            Timestamp time1 = new Timestamp(servicio.getFecha().getTime());
            String sql = "INSERT INTO biblioteca(id_servicio,nombre,"
                    + "descripcion,costo,relevancia,fecha,estado) VALUES("+
                    servicio.getIdServicio()+",'"+
                    servicio.getNombre()+"','"+
                    servicio.getDescripcion()+"',"+
                    servicio.getCosto()+","+
                    servicio.getRelevancia()+","+
                    (new java.sql.Date(servicio.getFecha().getTime()))+","+
                    String.valueOf(servicio.getEstado())+");";
            st = con.createStatement();
            resultado=st.executeUpdate(sql);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return resultado;
    }

    @Override
    public ArrayList<Servicio> listarTodos() {
        ArrayList<Servicio> servicios= new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM biblioteca;";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Servicio servicio = new Servicio();
                servicio.setIdServicio(rs.getInt("id_servicio"));
                servicio.setNombre(rs.getString("nombre"));
                servicio.setDescripcion(rs.getString("descripcion"));
                servicio.setCosto(rs.getDouble("costo"));
                servicio.setRelevancia(rs.getInt("relevancia"));
                servicio.setFecha(new java.sql.Date(rs.getDate("fecha").getTime()));
                servicio.setEstado(rs.getString("estado").charAt(0));
                servicios.add(servicio);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                rs.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                con.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return servicios;
    }
    
}
