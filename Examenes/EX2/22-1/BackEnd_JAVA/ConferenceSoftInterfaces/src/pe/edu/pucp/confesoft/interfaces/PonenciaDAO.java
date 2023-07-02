/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.confesoft.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.confesoft.model.Ponencia;

/**
 *
 * @author gabri
 */
public interface PonenciaDAO extends Remote{
    ArrayList<Ponencia>listarPorIdEvento(int idEvento)throws RemoteException;
}
