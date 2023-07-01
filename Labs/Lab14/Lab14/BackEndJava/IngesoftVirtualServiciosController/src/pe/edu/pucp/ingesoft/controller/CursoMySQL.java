/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.ingesoft.controller;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.ingesoft.config.DBManager;
import pe.edu.pucp.ingesoft.interfaces.CursoDAO;
import pe.edu.pucp.ingesoft.model.Curso;
import pe.edu.pucp.ingesoft.model.Especialidad;

public class CursoMySQL extends UnicastRemoteObject implements CursoDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public CursoMySQL(int puerto) throws RemoteException{
        super(puerto);
    }
    
    @Override
    public int insertar(Curso curso) throws RemoteException {
        int resultado = 0;
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_CURSO(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_curso", java.sql.Types.INTEGER);
            cs.setInt("_fid_especialidad", curso.getEspecialidad().getIdEspecialidad());
            cs.setString("_nombre", curso.getNombre());
            cs.setString("_clave", curso.getClave());
            cs.setDouble("_creditos", curso.getCreditos());
            cs.setDouble("_precio", curso.getPrecio());
            cs.setDate("_fecha_inicio", new java.sql.Date(curso.getFechaInicio().getTime()));
            cs.setDate("_fecha_fin", new java.sql.Date(curso.getFechaFin().getTime()));
            cs.executeUpdate();
            curso.setIdCurso(cs.getInt("_id_curso"));
            resultado = curso.getIdCurso();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public ArrayList<Curso> listarCursosPorNombre(String nombre) throws RemoteException {
        ArrayList<Curso> cursos = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_CURSOS_X_NOMBRE(?)}");
            cs.setString("_nombre", nombre);
            rs = cs.executeQuery();
            while(rs.next()){
                Curso curso = new Curso();
                curso.setIdCurso(rs.getInt("id_curso"));
                curso.setNombre(rs.getString("nombre_curso"));
                curso.setClave(rs.getString("clave"));
                curso.setCreditos(rs.getInt("creditos"));
                curso.setPrecio(rs.getInt("precio"));
                curso.setFechaInicio(rs.getDate("fecha_inicio"));
                curso.setFechaFin(rs.getDate("fecha_fin"));
                curso.setEspecialidad(new Especialidad());
                curso.getEspecialidad().setIdEspecialidad(rs.getInt("id_especialidad"));
                curso.getEspecialidad().setNombre(rs.getString("nombre_especialidad"));

                curso.setActivo(true);
                cursos.add(curso);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return cursos;
    }
    
}
