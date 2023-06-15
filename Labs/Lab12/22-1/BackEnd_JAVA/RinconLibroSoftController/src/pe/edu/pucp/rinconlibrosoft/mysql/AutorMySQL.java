/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.rinconlibrosoft.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.rinconlibrosoft.config.DBManager;
import pe.edu.pucp.rinconlibrosoft.dao.AutorDAO;
import pe.edu.pucp.rinconlibrosoft.model.Autor;

/**
 *
 * @author gabri
 */
public class AutorMySQL implements AutorDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public ArrayList<Autor> listarPorNombre(String nombre) {
        ArrayList<Autor> autores = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_AUTORES_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Autor autor = new Autor();
                autor.setIdAutor(rs.getInt("id_autor"));
                autor.setNombre(rs.getString("nombre"));
                autor.setApellidoPaterno(rs.getString("apellido_paterno"));
                autor.setNacionalidad(rs.getString("nacionalidad"));
                autores.add(autor);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return autores;
    }

    @Override
    public ArrayList<Autor> listarPorIdLibro(int idLibro) {
        ArrayList<Autor> autores = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_AUTORES_X_ID_LIBRO(?)}");
            cs.setInt("_id_libro", idLibro);
            rs = cs.executeQuery();
            while(rs.next()){
                Autor autor = new Autor();
                autor.setIdAutor(rs.getInt("id_autor"));
                autor.setNombre(rs.getString("nombre"));
                autor.setApellidoPaterno(rs.getString("apellido_paterno"));
                autor.setNacionalidad(rs.getString("nacionalidad"));
                autores.add(autor);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return autores;
    }
    
}
