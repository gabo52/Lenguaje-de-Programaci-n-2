
package pe.edu.pucp.ingesoft.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import pe.edu.pucp.ingesoft.model.Curso;

public interface CursoDAO extends Remote{
    int insertar(Curso curso) throws RemoteException;
    ArrayList<Curso> listarCursosPorNombre(String nombre)throws RemoteException;
}
