/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.confesoft.servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import pe.edu.pucp.confesoft.controller.EventoMySQL;
import pe.edu.pucp.confesoft.controller.IntegranteMySQL;
import pe.edu.pucp.confesoft.controller.PonenciaMySQL;
import pe.edu.pucp.confesoft.interfaces.EventoDAO;
import pe.edu.pucp.confesoft.interfaces.IntegranteDAO;
import pe.edu.pucp.confesoft.interfaces.PonenciaDAO;

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
            EventoDAO objEventoDAO = 
                    new EventoMySQL(Integer.parseInt(puerto));
            PonenciaDAO objPonenciaDAO = 
                    new PonenciaMySQL(Integer.parseInt(puerto));
            IntegranteDAO objIntegranteDAO = 
                    new IntegranteMySQL(Integer.parseInt(puerto));
            //Hacemos los objetos disponibles de forma remota
            Naming.rebind("//"+IP+":"+puerto+"/" + "daoEvento",objEventoDAO);
            Naming.rebind("//"+IP+":"+puerto+"/" + "daoPonencia",
                    objPonenciaDAO);
            Naming.rebind("//"+IP+":"+puerto+"/" + "daoIntegrante",
                    objIntegranteDAO);
            //Mensaje de exito
            System.out.println("El servidor se ha inicializado "
                    + "correctamente...");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
