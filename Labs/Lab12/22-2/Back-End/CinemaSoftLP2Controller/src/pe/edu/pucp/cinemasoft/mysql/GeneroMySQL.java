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
import pe.edu.pucp.cinemasoft.dao.GeneroDAO;
import pe.edu.pucp.cinemasoft.model.Genero;

/**
 *
 * @author gabri
 */
public class GeneroMySQL implements GeneroDAO{
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public ArrayList<Genero> listarTodos() {
        ArrayList<Genero> generos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_GENEROS_TODOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Genero genero = new Genero();
                genero.setIdGenero(rs.getInt("id_genero"));
                genero.setNombre(rs.getString("nombre"));
                genero.setActivo(true);
                generos.add(genero);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return generos;
    }
    
}
