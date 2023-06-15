Estructura del DB Manager:

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


# Descargas:

Descargamos el glashfish(el zip)
Colocamos la carpeta en el disco T.

Entramos al NetBeans
-> servers -> agregar servidor -> GlashFish Server
-> Colocamos la ruta del glashfish -> Next -> Next(si no queremos cambiar el nombre del dominio)
-> Finalizar

GlashFish configurado :D

# Preparacion

Creamos el DBManager con los datos de nuestra BD

Creamos un proyecto de tipo WebService(obtenido de Java with Ant con  Java Web) y seleccionamos
el servidor de Glashfish.

Creamos una webService como file type.

Ir a WebServices, testeas el servicio y pegas el WSDL al add service reference en Visual Studio.

Servicio agregado, hora de codear :).

No olvidemos agregar el jdbc y poner el nombre de la BD en el DBManager

Tampoco olvidemos el app.config

# FrontEnd:

##ComboBox
No olvidar al inicio:

cboGenero.ValueMember = "idGenero";
cboGenero.DisplayMember = "nombre";

Ni al final a la hora de insertar:

pelicula.genero.idGenero = (int)cboGenero.SelectedValue;
## FechaS
no olvidar el:

pelicula.fechaEstrenoSpecified = true;

para cargar una fecha obtenida de C# a JAVA, a la BD
cs.setDate("_fecha_publicacion", new java.sql.Date(libro.getFechaPublicacion().getTime()));

## Array a BindingList

actores = new BindingList<actor>(pelicula.actores.ToList());
para pasar el array de la bd al BindingList de C#

##Archivos a visualizar
frmGestionarEmpleados para listado de clases no maestro

## Formato WebService

@WebMethod(operationName = "listarAutoresPorNombre")
    public ArrayList<Autor> listarAutoresPorNombre(@WebParam(name = "nombre") String nombre) {
        ArrayList<Autor> autores = null;
        try{
            autores = daoAutor.listarPorNombre(nombre);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return autores;
    }
	
	 @WebMethod(operationName = "insertarLibro")
    public int insertarLibro(@WebParam(name = "libro") Libro libro) {
        int resultado=0;
        try{
            resultado = daoLibro.insertar(libro);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }


# Errores comunes:
olvidarse el Specified en el dtp
mandar parametros inexistentes en el cs, revisar los campos recogidos de la BD
no olvidar re-linkear el dgv a la hora de recoger varios campos de un array dentro de la clase maestro

no olvidar el config

AGREGAR A NOTAS EL TRY CATCH DE LOS SERVICES 