package pe.edu.pucp.rinconlibrosoft.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.rinconlibrosoft.config.DBManager;
import pe.edu.pucp.rinconlibrosoft.dao.EditorialDAO;
import pe.edu.pucp.rinconlibrosoft.model.Editorial;
public class EditorialMySQL implements EditorialDAO{

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    @Override
    public ArrayList<Editorial> listarPorNombre(String nombre) {
        ArrayList<Editorial> editoriales = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_EDITORIALES_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Editorial editorial = new Editorial();
                editorial.setIdEditorial(rs.getInt("id_editorial"));
                editorial.setNombre(rs.getString("nombre"));
                editorial.setActivo(true);
                editoriales.add(editorial);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return editoriales;
    }
}