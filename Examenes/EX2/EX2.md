# EXAMEN 2


# Preparación:

Agregar implements Serializable

Crear el DBManager

Código:

``` java

import java.sql.Connection;
import java.sql.DriverManager;
public class DBManager {
    private static DBManager dbManager;
    /* Gabriel Omar Duran Ruiz */
    /* Colocar la url de conexión */
    private String url = "jdbc:mysql://" +
            "database-lp2-newbd.cipfleuw5pam.us-east-1.rds.amazonaws.com"+
            ":3306/lp2newbd?useSSL=false";
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

```

Crear los proyectos para el RMI (Controller, Server e Interface)

Código Server:

``` java
    public class Servidor {
    private static String puerto = "1234";
    private static String IP = "127.0.0.1";
    
        public static void main(String[] args){
            try{
                System.setProperty("java.rmi.server.hostname",IP);
                LocateRegistry.createRegistry(Integer.parseInt(puerto));
                //Creamos las instacias de los objetos remotos
                CursoDAO objDAOCurso = 
                        new CursoMySQL(Integer.parseInt(puerto));
                EspecialidadDAO objDAOEspecialidad = 
                        new EspecialidadMySQL(Integer.parseInt(puerto));
                //Hacemos los objetos disponibles de forma remota
                Naming.rebind("//"+IP+":"+puerto+"/" + "daoCurso",objDAOCurso);
                Naming.rebind("//"+IP+":"+puerto+"/" + "daoEspecialidad",
                        objDAOEspecialidad);
                //Mensaje de exito
                System.out.println("El servidor se ha inicializado "
                        + "correctamente...");
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }


```

Para los DAO:

No olvidar los Remote y RemoteException
``` java
public interface EspecialidadDAO extends Remote{
    ArrayList<Especialidad> listarTodas()throws RemoteException;
}
``` 
Para los MySQL:

No olvidar el constructor y el UnicastRemoteObject

``` java
public class EspecialidadMySQL extends UnicastRemoteObject implements EspecialidadDAO{

    private Connection con;
    private ResultSet rs;
    private CallableStatement cs;
    
    public EspecialidadMySQL(int puerto) throws RemoteException{
        super(puerto);
    }
}
``` 

Para los Web Services:

No olvidar inicializar los DAO con la interfaz obtenida del servidor
``` java
    private static String IPServidor = "127.0.0.1";
    private static String puertoServidor = "1234";
    private CursoDAO objDAOCurso;
    private EspecialidadDAO objDAOEspecialidades;
        
    @WebMethod(operationName = "listarEspecialidadesTodas")
    public ArrayList<Especialidad> listarEspecialidadesTodas() {
        ArrayList<Especialidad> especialidades=null;
        try{
            objDAOEspecialidades = (EspecialidadDAO) Naming.lookup("//" + IPServidor + ":" + puertoServidor + "/" + "daoEspecialidad");
            especialidades = objDAOEspecialidades.listarTodas();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return especialidades;
    }
``` 
Lanzar el RMI(Server)

Conectamos el GlashFish:

Descargamos el glashfish(el zip)
Colocamos la carpeta en el disco T.

Entramos al NetBeans
-> servers -> agregar servidor -> GlashFish Server
-> Colocamos la ruta del glashfish -> Next -> Next(si no queremos cambiar el nombre del dominio)
-> Finalizar

GlashFish configurado :D

Agregamos el jdbc y la referencia al DBManager en el server.

Testeamos el Web Service, copiamos su link WSDL a las referencias del VS.
Y listo, comenzamos a codear :D



## Archivos a revisar:

Front-End:
GestionarOrdenesVenta
BuscarOrdenesVenta
BuscarClientes

ServiciosWS

BackEnd:

OrdenesVentaMySQL
ClientesMySQL


convertir a java.sql.date

new java.sql.date(fecha.getTime());

