/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.confesoft.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.confesoft.config.DBManager;
import pe.edu.pucp.confesoft.interfaces.IntegranteDAO;
import pe.edu.pucp.confesoft.model.Integrante;
import pe.edu.pucp.confesoft.model.TipoIntegrante;

/**
 *
 * @author gabri
 */
public class IntegranteMySQL extends UnicastRemoteObject implements IntegranteDAO{

    private Connection con;
    private CallableStatement cs;
    private ResultSet rs;
    
    public IntegranteMySQL(int i) throws RemoteException {
        super(i);
    }

    @Override
    public ArrayList<Integrante> listarPorNombreTipo(String nombre, char tipo) throws RemoteException {
        ArrayList<Integrante> integrantes = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_INTEGRANTES_X_NOMBRE_TIPO(?,?)}");
            cs.setString("_nombre", nombre);
            cs.setString("_tipo", String.valueOf(tipo));
            rs = cs.executeQuery();
            while(rs.next()){
                Integrante integrante = new Integrante();

                integrante.setIdIntegrante(rs.getInt("id_integrante"));
                integrante.setCodigoPUCP(rs.getString("codigo_PUCP"));
                integrante.setNombre(rs.getString("nombre"));
                integrante.setApellidoPaterno(rs.getString("apellido_paterno"));
                
                integrante.setTipoIntegrante(new TipoIntegrante());
                integrante.getTipoIntegrante().setIdTipoIntegrante(rs.getInt("id_tipo_integrante"));
                integrante.getTipoIntegrante().setDescripcion(rs.getString("descripcion"));
                integrante.setActivo(rs.getBoolean("activo"));
                
                integrantes.add(integrante);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return integrantes;
    }
    
}
