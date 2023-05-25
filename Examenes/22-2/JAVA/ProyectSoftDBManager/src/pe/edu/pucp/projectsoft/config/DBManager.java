/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.projectsoft.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gabri
 */
public class DBManager {
    private static DBManager dbManager;
    private String url = "jdbc:mysql://" +
    "lab05-lengpro2-2023-1.cijqnwrnhufq.us-east-1.rds.amazonaws.com" +
            ":3306/lp2lab05";
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
            //Registrar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Se realizó la conexión");
            //Realizar la conexión
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
