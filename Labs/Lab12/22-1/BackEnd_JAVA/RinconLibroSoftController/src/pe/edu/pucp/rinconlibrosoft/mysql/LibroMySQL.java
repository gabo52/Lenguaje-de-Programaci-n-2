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
import pe.edu.pucp.rinconlibrosoft.dao.LibroDAO;
import pe.edu.pucp.rinconlibrosoft.model.Autor;
import pe.edu.pucp.rinconlibrosoft.model.Editorial;
import pe.edu.pucp.rinconlibrosoft.model.Libro;

/**
 *
 * @author gabri
 */
public class LibroMySQL implements LibroDAO {
    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Libro libro) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_LIBRO(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_libro", java.sql.Types.INTEGER);
            cs.setInt("_fid_editorial", libro.getEditorial().getIdEditorial());
            cs.setString("_fid_idioma",String.valueOf( libro.getIdioma()));
            cs.setString("_titulo", libro.getTitulo());
            cs.setDouble("_nro_paginas", libro.getNroPaginas());
            cs.setDate("_fecha_publicacion", new java.sql.Date(libro.getFechaPublicacion().getTime()));
            cs.setDouble("_precio", libro.getPrecio());
            cs.setBytes("_portada", libro.getPortada());
            cs.executeUpdate();
            libro.setIdLibro(cs.getInt("_id_libro"));
            for(Autor autor : libro.getAutores()){
                cs = con.prepareCall("{call INSERTAR_LIBRO_AUTOR(?,?)}");
                cs.setInt("_fid_libro", libro.getIdLibro());
                cs.setInt("_fid_autor", autor.getIdAutor());
                cs.executeUpdate();
            }
            resultado = libro.getIdLibro();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Libro> listarPorTituloOEditorial(String tituloOEditorial) {
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_LIBROS_X_TITULO_O_EDITORIAL(?)}");
            cs.setString("_titulo_editorial", tituloOEditorial);
            rs = cs.executeQuery();
            while(rs.next()){
                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("id_libro"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setIdioma(rs.getString("fid_idioma").charAt(0));
                libro.setNroPaginas(rs.getInt("nro_paginas"));
                libro.setFechaPublicacion(rs.getDate("fecha_publicacion"));
                libro.setPrecio(rs.getDouble("precio"));
                libro.setPortada(rs.getBytes("portada"));
                libro.setEditorial(new Editorial());
                libro.getEditorial().setIdEditorial(rs.getInt("fid_editorial"));
                libro.getEditorial().setNombre(rs.getString("nombre_editorial"));
                libros.add(libro);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return libros;
    }
    
}
