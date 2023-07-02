/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.pucp.confesoft.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.confesoft.model.Integrante;

/**
 *
 * @author gabri
 */
public interface IntegranteDAO extends Remote{
    ArrayList<Integrante> listarPorNombreTipo(String nombre, char tipo)throws RemoteException;
}
