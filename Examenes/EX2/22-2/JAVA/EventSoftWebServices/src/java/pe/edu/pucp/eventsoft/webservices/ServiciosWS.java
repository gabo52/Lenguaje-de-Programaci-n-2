/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.eventsoft.webservices;

import java.rmi.Naming;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.eventsoft.interfaces.ActividadDAO;
import pe.edu.pucp.eventsoft.interfaces.DocenteDAO;
import pe.edu.pucp.eventsoft.interfaces.EspecialidadDAO;
import pe.edu.pucp.eventsoft.interfaces.EventoDAO;
import pe.edu.pucp.eventsoft.model.Actividad;
import pe.edu.pucp.eventsoft.model.Docente;
import pe.edu.pucp.eventsoft.model.Especialidad;
import pe.edu.pucp.eventsoft.model.Evento;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "ServiciosWS")
public class ServiciosWS {

    /**
     * This is a sample web service operation
     */
    private static String IPServidor = "127.0.0.1";
    private static String puertoServidor = "1234";
    private EventoDAO objDAOEvento;
    private ActividadDAO objDAOActividad;
    private DocenteDAO objDAODocente;
    private EspecialidadDAO objDAOEspecialidad;
    
    @WebMethod(operationName = "listarActividadesPorIdEvento")
    public ArrayList<Actividad> listarActividadesPorIdEvento(@WebParam(name = "idEvento") int idEvento) {
        ArrayList<Actividad> actividades = null;
        try{
            objDAOActividad = (ActividadDAO) Naming.lookup("//" + 
                    IPServidor + ":" + puertoServidor + "/" + "daoActividad");
            actividades = objDAOActividad.listarPorIdEvento(idEvento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return actividades;
    }
    
    @WebMethod(operationName = "listarDocentesPorCodigoPUCPNombreIdEspecialidad")
    public ArrayList<Docente> listarDocentesPorCodigoPUCPNombreIdEspecialidad(
            @WebParam(name = "nombre")  String codigoPUCPNombre,@WebParam(name = "idEspecialidad")  int idEspecialidad) {
        ArrayList<Docente> docentes = null;
        try{
            objDAODocente = (DocenteDAO) Naming.lookup("//" + 
                    IPServidor + ":" + puertoServidor + "/" + "daoDocente");
            docentes = objDAODocente.listarPorCodigoPUCPNombreIdEspecialidad(codigoPUCPNombre,idEspecialidad);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return docentes;
    }
    
    @WebMethod(operationName = "listarDocentePorIdEvento")
    public ArrayList<Docente> listarDocentePorIdEvento(@WebParam(name = "idEvento") int idEvento) {
        ArrayList<Docente> docentes = null;
        try{
            objDAODocente = (DocenteDAO) Naming.lookup("//" + 
                    IPServidor + ":" + puertoServidor + "/" + "daoDocente");
            docentes = objDAODocente.listarPorIdEvento(idEvento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return docentes;
    }
    
    @WebMethod(operationName = "listarEspecialidadesTodas")
    public ArrayList<Especialidad> listarEspecialidadesTodas() {
        ArrayList<Especialidad> especialidades = null;
        try{
            objDAOEspecialidad = (EspecialidadDAO) Naming.lookup("//" + 
                    IPServidor + ":" + puertoServidor + "/" + "daoEspecialidad");
            especialidades = objDAOEspecialidad.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return especialidades;
    }
    
    @WebMethod(operationName = "insertarEvento")
    public int insertarEvento(@WebParam(name = "evento") Evento evento) {
        int resultado=0;
        try{
            objDAOEvento = (EventoDAO) Naming.lookup("//" + 
                    IPServidor + ":" + puertoServidor + "/" + "daoEvento");
            resultado = objDAOEvento.insertar(evento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarEventosPorNombre")
    public  ArrayList<Evento>listarEventosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Evento> eventos = null;
        try{
            objDAOEvento = (EventoDAO) Naming.lookup("//" + 
                    IPServidor + ":" + puertoServidor + "/" + "daoEvento");
            eventos = objDAOEvento.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return eventos;
    }
}
