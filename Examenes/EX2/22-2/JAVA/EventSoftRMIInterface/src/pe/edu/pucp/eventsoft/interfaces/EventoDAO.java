/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.eventsoft.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.eventsoft.model.Evento;

/**
 *
 * @author gabri
 */
public interface EventoDAO extends Remote{
    int insertar(Evento evento)throws RemoteException;
    ArrayList<Evento> listarPorNombre(String nombre)throws RemoteException;
}
