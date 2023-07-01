/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.projectsoft.MySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.projectsoft.DAO.EstudianteDAO;
import pe.edu.pucp.projectsoft.config.DBManager;
import pe.edu.pucp.projectsoft.model.Estudiante;

/**
 *
 * @author gabri
 */
public class EstudianteMySQL implements EstudianteDAO {

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    @Override
    public ArrayList<Estudiante> listarTodos(String cadena) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_ESTUDIANTES_X_CODIGOPUCP_NOMBRE(?)}");
            cs.setString("_codigoPUCP_nombre", cadena);
            rs = cs.executeQuery();
            while(rs.next()){
                Estudiante estudiante = new Estudiante();
                estudiante.setIdPersona(rs.getInt("id_persona"));
                estudiante.setCodigoPUCP(rs.getString("codigo_PUCP"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellidoPaterno(rs.getString("apellido_paterno"));
                estudiante.setCRAEST(rs.getDouble("CRAEST"));
                estudiantes.add(estudiante);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return estudiantes;
    }
    
}
