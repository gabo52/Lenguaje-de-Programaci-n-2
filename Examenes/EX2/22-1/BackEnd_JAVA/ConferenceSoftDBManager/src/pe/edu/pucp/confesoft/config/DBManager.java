/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.confesoft.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBManager {
    private static DBManager dbManager;
    /* Gabriel Omar Duran Ruiz */
    /* Colocar la url de conexión */
    private String url = "jdbc:mysql://" +
            "lab05-lengpro2-2023-1.cijqnwrnhufq.us-east-1.rds.amazonaws.com"+
            ":3306/lp2lab05?useSSL=false";
    private String user = "admin";
    private String password = "inf282lp220231";
    private Connection con;
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
    }
    
    public Connection getConnection(){
        try{
            //Registrar el Driver (ensamblado) de conexión
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    public static DBManager getInstance(){
        if(dbManager == null){
            createInstance();
        }
        return dbManager;
    }
}
