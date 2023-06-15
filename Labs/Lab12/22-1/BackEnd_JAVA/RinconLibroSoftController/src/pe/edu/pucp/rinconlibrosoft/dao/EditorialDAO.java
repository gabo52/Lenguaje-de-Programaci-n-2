package pe.edu.pucp.rinconlibrosoft.dao;
import java.util.ArrayList;
import pe.edu.pucp.rinconlibrosoft.model.Editorial;
public interface EditorialDAO {
    ArrayList<Editorial> listarPorNombre(String nombre);
}