/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.servicesoft.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gabri
 */
public class DBManager {
    private static DBManager dbManager;
    String url="jdbc:mysql://"+
            "database-lp2.cltajd5unnlf.us-east-1.rds.amazonaws.com"+
            ":3306/lp2";
    String user="admin";
    String password="rcWgHuMV2YpVPZ8";
    public Connection con;
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager= new DBManager();
        }
    }
    
    public Connection getConnection(){
        try{
            //Registrar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
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
