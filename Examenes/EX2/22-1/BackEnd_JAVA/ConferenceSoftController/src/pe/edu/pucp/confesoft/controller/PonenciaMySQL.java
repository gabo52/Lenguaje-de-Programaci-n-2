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
import pe.edu.pucp.confesoft.interfaces.PonenciaDAO;
import pe.edu.pucp.confesoft.model.Integrante;
import pe.edu.pucp.confesoft.model.Ponencia;

/**
 *
 * @author gabri
 */
public class PonenciaMySQL  extends UnicastRemoteObject implements PonenciaDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public PonenciaMySQL(int i) throws RemoteException {
        super(i);
    }

    @Override
    public ArrayList<Ponencia> listarPorIdEvento(int idEvento) throws RemoteException {
        ArrayList<Ponencia> ponencias = new ArrayList<>();
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call LISTAR_PONENCIAS_X_ID_EVENTO(?)}");
            cs.setInt("_id_evento", idEvento);
            rs = cs.executeQuery();
            while(rs.next()){
                Ponencia ponencia = new Ponencia();
                ponencia.setIdPonencia(rs.getInt("id_ponencia"));
                ponencia.setTitulo(rs.getString("titulo"));
                ponencia.setHoraInicio(rs.getTime("hora_inicio"));
                ponencia.setHoraFin(rs.getTime("hora_fin"));
                ponencia.setPonente(new Integrante());
                ponencia.getPonente().setIdIntegrante(rs.getInt("id_integrante"));
                ponencia.getPonente().setNombre(rs.getString("nombre"));
                ponencia.getPonente().setApellidoPaterno(rs.getString("apellido_paterno"));
                ponencias.add(ponencia);
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return ponencias;
    }
    
}
