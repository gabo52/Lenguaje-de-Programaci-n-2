package com.librarysoft.logistica.mysql;

import com.librarysoft.config.DBManager;
import com.librarysoft.logistica.dao.BibliotecaDAO;
import com.librarysoft.logistica.model.Biblioteca;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class BibliotecaMySQL implements BibliotecaDAO{
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    @Override
    public int insertar(Biblioteca biblioteca) {
        int resultado=0;
        Time time;
        try{
            con = DBManager.getInstance().getConnection();
            //Instruccion SQL
            String sql = "INSERT INTO biblioteca(nombre,hora_apertura,"
                    + "hora_cierre,ubicada_en_campus,activa) VALUES('"+
                    biblioteca.getNombre()+"','"+
                    Time.valueOf(biblioteca.getHoraApertura())+"','"+
                    Time.valueOf(biblioteca.getHoraCierre())+"',"+
                    biblioteca.isUbicadaEnCampus()+","+true+");";
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

    public ArrayList<Biblioteca> listarTodas() {
        ArrayList<Biblioteca> bibliotecas= new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            String sql = "SELECT * FROM biblioteca;";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(rs.getInt("id_biblioteca"));
                biblioteca.setNombre(rs.getString("nombre"));
                biblioteca.setHoraApertura(rs.getTime("hora_apertura").toLocalTime());
                biblioteca.setHoraCierre(rs.getTime("hora_cierre").toLocalTime());
                biblioteca.setUbicadaEnCampus(rs.getBoolean("ubicada_en_campus"));
                biblioteca.setActiva(rs.getBoolean("activa"));
                bibliotecas.add(biblioteca);
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
        return bibliotecas;
    }

    
}
