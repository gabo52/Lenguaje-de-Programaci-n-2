/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.ingesoft.webservices;

import java.rmi.Naming;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.ingesoft.interfaces.CursoDAO;
import pe.edu.pucp.ingesoft.interfaces.EspecialidadDAO;
import pe.edu.pucp.ingesoft.model.Curso;
import pe.edu.pucp.ingesoft.model.Especialidad;


@WebService(serviceName = "ServiciosWS")
public class ServiciosWS {


    private static String IPServidor = "127.0.0.1";
    private static String puertoServidor = "1234";
    private CursoDAO objDAOCurso;
    private EspecialidadDAO objDAOEspecialidades;
        
    @WebMethod(operationName = "listarEspecialidadesTodas")
    public ArrayList<Especialidad> listarEspecialidadesTodas() {
        ArrayList<Especialidad> especialidades=null;
        try{
            objDAOEspecialidades = (EspecialidadDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoEspecialidad");
            especialidades = objDAOEspecialidades.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return especialidades;
    }
    
    @WebMethod(operationName = "listarCursosPorNombre")
    public ArrayList<Curso> listarCursosPorNombre(@WebParam(name = "nombre")String nombre) {
        ArrayList<Curso> cursos=null;
        try{
            objDAOCurso = (CursoDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoCurso");
            cursos = objDAOCurso.listarCursosPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cursos;
    }
    
    @WebMethod(operationName = "insertarCurso")
    public int insertarCurso(@WebParam(name = "curso")Curso curso) {
        int resultado=0;
        try{
            objDAOCurso = (CursoDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoCurso");
            resultado = objDAOCurso.insertar(curso);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
