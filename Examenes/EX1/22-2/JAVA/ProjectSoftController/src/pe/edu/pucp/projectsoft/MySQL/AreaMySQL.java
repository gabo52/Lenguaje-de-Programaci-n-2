/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.projectsoft.MySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.projectsoft.DAO.AreaDAO;
import pe.edu.pucp.projectsoft.config.DBManager;
import pe.edu.pucp.projectsoft.model.Area;

/**
 *
 * @author gabri
 */
public class AreaMySQL implements AreaDAO
{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    @Override
    public ArrayList<Area> listarTodas() {
        ArrayList<Area> areas = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_AREAS_TODAS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Area area = new Area();
                area.setActivo(true);
                area.setIdArea(rs.getInt("id_area"));
                area.setNombre(rs.getString("nombre"));
                areas.add(area);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return areas;
    }
    
}
