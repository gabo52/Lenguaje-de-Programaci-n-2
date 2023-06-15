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
import pe.edu.pucp.cinemasoft.dao.PeliculaDAO;
import pe.edu.pucp.cinemasoft.model.Actor;
import pe.edu.pucp.cinemasoft.model.Genero;
import pe.edu.pucp.cinemasoft.model.Pelicula;

/**
 *
 * @author gabri
 */
public class PeliculaMySQL implements PeliculaDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public int insertar(Pelicula pelicula) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PELICULA(?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_pelicula", java.sql.Types.INTEGER);
            cs.setInt("_fid_genero", pelicula.getGenero().getIdGenero());
            cs.setString("_titulo", pelicula.getTitulo());
            cs.setDate("_fecha_estreno", new java.sql.Date(pelicula.getFechaEstreno().getTime()));
            cs.setBoolean("_disponible_subtitulada", pelicula.isDisponibleSubtitulada());
            cs.setBoolean("_disponible_doblada", pelicula.isDisponibleDoblada());
            cs.setString("_sinopsis", pelicula.getSinopsis());
            cs.setBytes("_portada", pelicula.getPortada());
            cs.setTime("_duracion", pelicula.getDuracion());
            cs.executeUpdate();
            pelicula.setIdPelicula(cs.getInt("_id_pelicula"));
            for(Actor actor : pelicula.getActores()){
                cs = con.prepareCall("{call INSERTAR_PELICULA_ACTOR(?,?,?)}");
                cs.registerOutParameter("_id_pelicula_actor", java.sql.Types.INTEGER);
                cs.setInt("_fid_pelicula", pelicula.getIdPelicula());
                cs.setInt("_fid_actor", actor.getIdActor());
                cs.executeUpdate();
            }
            resultado = pelicula.getIdPelicula();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Pelicula> listarPorTitulo(String titulo) {
         ArrayList<Pelicula> peliculas = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PELICULAS_X_TITULO(?)}");
            cs.setString("_titulo", titulo);
            rs = cs.executeQuery();
            while(rs.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setIdPelicula(rs.getInt("id_pelicula"));
                pelicula.setGenero(new Genero());
                pelicula.getGenero().setIdGenero(rs.getInt("id_genero"));
                pelicula.getGenero().setNombre(rs.getString("nombre_genero"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setFechaEstreno(rs.getDate("fecha_estreno"));
                pelicula.setDuracion(rs.getTime("duracion"));
                pelicula.setDisponibleSubtitulada(rs.getBoolean("disponible_subtitulada"));
                pelicula.setDisponibleDoblada(rs.getBoolean("disponible_doblada"));
                pelicula.setSinopsis(rs.getString("sinopsis"));
                pelicula.setPortada(rs.getBytes("portada"));
                peliculas.add(pelicula);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return peliculas;
    }
    
}
