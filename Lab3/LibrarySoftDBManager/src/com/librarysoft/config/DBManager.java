package com.librarysoft.config;

import java.sql.Connection;
import java.sql.DriverManager;

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
