package pe.edu.pucp.cinemasoft.config;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBManager {
    private static DBManager dbManager;
    /* Colocar su nombre y código */
    /* Colocar la url de conexión */
    private String url = "?useSSL=false";
    private String user = "";
    private String password = "";
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