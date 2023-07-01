/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ingesoft.rmi.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import pe.edu.pucp.ingesoft.controller.CursoMySQL;
import pe.edu.pucp.ingesoft.controller.EspecialidadMySQL;
import pe.edu.pucp.ingesoft.interfaces.CursoDAO;
import pe.edu.pucp.ingesoft.interfaces.EspecialidadDAO;

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
            CursoDAO objDAOCurso = 
                    new CursoMySQL(Integer.parseInt(puerto));
            EspecialidadDAO objDAOEspecialidad = 
                    new EspecialidadMySQL(Integer.parseInt(puerto));
            //Hacemos los objetos disponibles de forma remota
            Naming.rebind("//"+IP+":"+puerto+"/" + "daoCurso",objDAOCurso);
            Naming.rebind("//"+IP+":"+puerto+"/" + "daoEspecialidad",
                    objDAOEspecialidad);
            //Mensaje de exito
            System.out.println("El servidor se ha inicializado "
                    + "correctamente...");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
