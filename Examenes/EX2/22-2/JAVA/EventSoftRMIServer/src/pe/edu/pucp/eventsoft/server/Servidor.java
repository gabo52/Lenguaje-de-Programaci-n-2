/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.eventsoft.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import pe.edu.pucp.eventsoft.controller.ActividadMySQL;
import pe.edu.pucp.eventsoft.controller.DocenteMySQL;
import pe.edu.pucp.eventsoft.controller.EspecialidadMySQL;
import pe.edu.pucp.eventsoft.controller.EventoMySQL;
import pe.edu.pucp.eventsoft.interfaces.ActividadDAO;
import pe.edu.pucp.eventsoft.interfaces.DocenteDAO;
import pe.edu.pucp.eventsoft.interfaces.EspecialidadDAO;
import pe.edu.pucp.eventsoft.interfaces.EventoDAO;

/**
 *
 * @author gabri
 */
public class Servidor {
    private static String puerto = "1234";
    private static String IP = "127.0.0.1";
    
        public static void main(String[] args){
            try{
                System.setProperty("java.rmi.server.hostname",IP);
                LocateRegistry.createRegistry(Integer.parseInt(puerto));
                //Creamos las instacias de los objetos remotos
                ActividadDAO objDAOActividad = 
                        new ActividadMySQL(Integer.parseInt(puerto));
                DocenteDAO objDAODocente = 
                        new DocenteMySQL(Integer.parseInt(puerto));
                EspecialidadDAO objDAOEspecialidad = 
                        new EspecialidadMySQL(Integer.parseInt(puerto));
                EventoDAO objDAOEvento = 
                        new EventoMySQL(Integer.parseInt(puerto));
                //Hacemos los objetos disponibles de forma remota
                Naming.rebind("//"+IP+":"+puerto+"/" + "daoActividad",objDAOActividad);
                Naming.rebind("//"+IP+":"+puerto+"/" + "daoDocente",
                        objDAODocente);
                Naming.rebind("//"+IP+":"+puerto+"/" + "daoEspecialidad",
                        objDAOEspecialidad);
                Naming.rebind("//"+IP+":"+puerto+"/" + "daoEvento",
                        objDAOEvento);
                //Mensaje de exito
                System.out.println("El servidor se ha inicializado "
                        + "correctamente...");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }