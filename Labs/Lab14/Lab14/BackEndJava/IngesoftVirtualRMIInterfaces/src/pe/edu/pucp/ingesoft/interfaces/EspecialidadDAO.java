
package pe.edu.pucp.ingesoft.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.ingesoft.model.Especialidad;

public interface EspecialidadDAO extends Remote{
    ArrayList<Especialidad> listarTodas()throws RemoteException;
}
