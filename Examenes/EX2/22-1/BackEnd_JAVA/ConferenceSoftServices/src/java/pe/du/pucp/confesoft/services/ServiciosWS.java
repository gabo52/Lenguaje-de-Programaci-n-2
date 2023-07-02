/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.du.pucp.confesoft.services;

import java.rmi.Naming;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.pucp.confesoft.interfaces.EventoDAO;
import pe.edu.pucp.confesoft.interfaces.IntegranteDAO;
import pe.edu.pucp.confesoft.interfaces.PonenciaDAO;
import pe.edu.pucp.confesoft.model.Evento;
import pe.edu.pucp.confesoft.model.Integrante;
import pe.edu.pucp.confesoft.model.Ponencia;

/**
 *
 * @author gabri
 */
@WebService(serviceName = "ServiciosWS")
public class ServiciosWS {
    private static String IPServidor = "127.0.0.1";
    private static String puertoServidor = "1234";
    private EventoDAO objEventoDAO;
    private PonenciaDAO objPonenciaDAO;
    private IntegranteDAO objIntegranteDAO;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "insertarEvento")
    public int insertarEvento(@WebParam(name = "evento") Evento evento) {
        int resultado=0;
        try{
            objEventoDAO = (EventoDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoEvento");
            resultado = objEventoDAO.insertar(evento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarEventosPorNombre")
    public ArrayList<Evento> listarEventosPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Evento> eventos=null;
        try{
            objEventoDAO = (EventoDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoEvento");
            eventos = objEventoDAO.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return eventos;
    }
    
    @WebMethod(operationName = "listarPonenciasPorIdEvento")
    public ArrayList<Ponencia>listarPonenciasPorIdEvento(@WebParam(name = "idEvento") int idEvento) {
        ArrayList<Ponencia> ponencias=null;
        try{
            objPonenciaDAO = (PonenciaDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoPonencia");
            ponencias = objPonenciaDAO.listarPorIdEvento(idEvento);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return ponencias;
    }
    
        @WebMethod(operationName = "listarIntegrantesPorNombreTipo")
    public ArrayList<Integrante>listarIntegrantesPorNombreTipo(
            @WebParam(name = "nombre") String nombre,@WebParam(name = "tipo") char tipo) {
        ArrayList<Integrante> integrantes=null;
        try{
            objIntegranteDAO = (IntegranteDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoIntegrante");
            integrantes = objIntegranteDAO.listarPorNombreTipo(nombre,tipo);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return integrantes;
    }
}
