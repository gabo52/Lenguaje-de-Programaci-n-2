/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.rinconlibrosoft.services;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.rinconlibrosoft.dao.AutorDAO;
import pe.edu.pucp.rinconlibrosoft.dao.EditorialDAO;
import pe.edu.pucp.rinconlibrosoft.dao.LibroDAO;
import pe.edu.pucp.rinconlibrosoft.model.Autor;
import pe.edu.pucp.rinconlibrosoft.model.Editorial;
import pe.edu.pucp.rinconlibrosoft.model.Libro;
import pe.edu.pucp.rinconlibrosoft.mysql.AutorMySQL;
import pe.edu.pucp.rinconlibrosoft.mysql.EditorialMySQL;
import pe.edu.pucp.rinconlibrosoft.mysql.LibroMySQL;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "ServiciosWS")
public class ServiciosWS {
    AutorDAO daoAutor = new AutorMySQL();
    LibroDAO daoLibro = new LibroMySQL();
    EditorialDAO daoEditorial = new EditorialMySQL();
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "listarAutoresPorNombre")
    public ArrayList<Autor> listarAutoresPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Autor> autores = null;
        try{
            autores = daoAutor.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return autores;
    }
    
    @WebMethod(operationName = "listarAutoresPorIdLibro")
    public ArrayList<Autor> listarAutoresPorIdLibro(@WebParam(name = "idLibro") int idLibro) {
        ArrayList<Autor> autores = null;
        try{
            autores = daoAutor.listarPorIdLibro(idLibro);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return autores;
    }
    
    @WebMethod(operationName = "insertarLibro")
    public int insertarLibro(@WebParam(name = "libro") Libro libro) {
        int resultado=0;
        try{
            resultado = daoLibro.insertar(libro);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarLibrosPorTituloOEditorial")
    public ArrayList<Libro> listarLibrosPorTituloOEditorial(@WebParam(name = "tituloOEditorial") String tituloOEditorial) {
        ArrayList<Libro> libros = null;
        try{
            libros = daoLibro.listarPorTituloOEditorial(tituloOEditorial);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return libros;
    }
    
    @WebMethod(operationName = "listarEditorialPorNombre")
    public ArrayList<Editorial> listarEditorialPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Editorial> editoriales = null;
        try{
            editoriales = daoEditorial.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return editoriales;
    }
    
}
