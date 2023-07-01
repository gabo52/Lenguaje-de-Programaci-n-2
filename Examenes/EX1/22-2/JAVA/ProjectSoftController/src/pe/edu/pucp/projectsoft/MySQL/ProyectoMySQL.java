/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.projectsoft.MySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.projectsoft.DAO.ProyectoDAO;
import pe.edu.pucp.projectsoft.config.DBManager;
import pe.edu.pucp.projectsoft.model.Area;
import pe.edu.pucp.projectsoft.model.Estudiante;
import pe.edu.pucp.projectsoft.model.Proyecto;

/**
 *
 * @author gabri
 */
public class ProyectoMySQL implements ProyectoDAO {

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public int insertar(Proyecto proyecto) {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_PROYECTO(?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_proyecto", java.sql.Types.INTEGER);
            cs.setInt("_fid_area", proyecto.getArea().getIdArea());
            cs.setInt("_fid_estudiante", proyecto.getEstudiante().getIdPersona());
            cs.setString("_titulo", proyecto.getTitulo());
            cs.setString("_descripcion", proyecto.getDescripcion());
            cs.setBytes("_foto", proyecto.getFoto());
            cs.setBytes("_archivo_tema_tesis", proyecto.getArchivoTemaTesis());
            cs.executeUpdate();
            proyecto.setIdProyecto(cs.getInt("_id_proyecto"));
            resultado = proyecto.getIdProyecto();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Proyecto> listarPorTituloCodigoPUCPNombre(String cadena) {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PROYECTOS_X_TITULO_CODIGOPUCP_NOMBRE_TESISTA(?)}");
            cs.setString("_titulo_codigoPUCP_nombre", cadena);
            rs = cs.executeQuery();
            while(rs.next()){
                Proyecto proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));
                
                proyecto.setArea(new Area());
                proyecto.getArea().setIdArea(rs.getInt("id_area"));
                proyecto.getArea().setNombre(rs.getString("nombre_area"));
                proyecto.setTitulo(rs.getString("titulo"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setFoto(rs.getBytes("foto"));
                proyecto.setArchivoTemaTesis(rs.getBytes("archivo_tema_tesis"));
                
                proyecto.setEstudiante(new Estudiante());
                proyecto.getEstudiante().setIdPersona(rs.getInt("id_estudiante"));
                proyecto.getEstudiante().setCodigoPUCP(rs.getString("codigo_PUCP"));
                proyecto.getEstudiante().setNombre(rs.getString("nombre_estudiante"));
                proyecto.getEstudiante().setApellidoPaterno(rs.getString("apellido_paterno"));
                proyecto.getEstudiante().setCRAEST(rs.getInt("CRAEST"));
                
                proyecto.setIdProyecto(rs.getInt("id_proyecto"));

                proyecto.setActivo(true);
                proyectos.add(proyecto);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return proyectos;
    }
    
}
