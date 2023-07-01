package pe.edu.pucp.eventsoft.config;

import java.sql.Connection;
import java.sql.DriverManager;

    /* Gabriel Omar Duran Ruiz */
    /* Colocar la url de conexión */
public class DBManager {
    private static DBManager dbManager;
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
