/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.cinemasoft.webservices;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.cinemasoft.dao.ActorDAO;
import pe.edu.pucp.cinemasoft.dao.GeneroDAO;
import pe.edu.pucp.cinemasoft.dao.PeliculaDAO;
import pe.edu.pucp.cinemasoft.model.Actor;
import pe.edu.pucp.cinemasoft.model.Genero;
import pe.edu.pucp.cinemasoft.model.Pelicula;
import pe.edu.pucp.cinemasoft.mysql.ActorMySQL;
import pe.edu.pucp.cinemasoft.mysql.GeneroMySQL;
import pe.edu.pucp.cinemasoft.mysql.PeliculaMySQL;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "ServiciosWS")
public class ServiciosWS {

    /**
     * This is a sample web service operation
     */
    GeneroDAO daoGenero = new GeneroMySQL();
    ActorDAO daoActor = new ActorMySQL();
    PeliculaDAO daoPelicula = new PeliculaMySQL();
    
    @WebMethod(operationName = "listarGenerosTodos")
    public ArrayList<Genero> listarGenerosTodos() {
        ArrayList<Genero> generos = null;
        try{
            generos = daoGenero.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return generos;
    }
    
    @WebMethod(operationName = "listarActoresPorNombre")
    public ArrayList<Actor> listarActoresPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Actor> actores = null;
        try{
            actores = daoActor.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return actores;
    }
    
    @WebMethod(operationName = "insertarPelicula")
    public int insertarPelicula(@WebParam(name = "pelicula") Pelicula pelicula) {
        int resultado =0;
        try{
            resultado = daoPelicula.insertar(pelicula);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarPeliculasPorTitulo")
    public ArrayList<Pelicula> listarPeliculasPorTitulo(@WebParam(name = "pelicula") String titulo) {
        ArrayList<Pelicula> peliculas = null;
        try{
            peliculas = daoPelicula.listarPorTitulo(titulo);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return peliculas;
    }
    
    @WebMethod(operationName = "listarActoresPorIdPelicula")
    public ArrayList<Actor> listarActoresPorIdPelicula(@WebParam(name = "idPelicula") int idPelicula) {
        ArrayList<Actor> actores = null;
        try{
            actores = daoActor.listarPorIdPelicula(idPelicula);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return actores;
    }
}
