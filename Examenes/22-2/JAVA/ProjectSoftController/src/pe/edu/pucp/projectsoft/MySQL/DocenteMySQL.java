/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.projectsoft.MySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.projectsoft.DAO.DocenteDAO;
import pe.edu.pucp.projectsoft.config.DBManager;
import pe.edu.pucp.projectsoft.model.Docente;

/**
 *
 * @author gabri
 */
public class DocenteMySQL implements DocenteDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public ArrayList<Docente> listarPorCodigoPUCPNombre(String nombre) {
        ArrayList<Docente> docentes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE(?)}");
            cs.setString("_codigoPUCP_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Docente doc = new Docente();
                doc.setIdPersona(rs.getInt("id_persona"));
                doc.setCodigoPUCP(rs.getString("codigo_PUCP"));
                doc.setNombre(rs.getString("nombre"));
                doc.setApellidoPaterno(rs.getString("apellido_paterno"));
                doc.setCategoria(rs.getString("categoria"));
                docentes.add(doc);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return docentes;
    }
    
}
