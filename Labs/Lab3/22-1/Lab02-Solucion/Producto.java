public abstract class Producto implements IConsultable{
    private static int id = 1;
    private int idProducto;
    private String nombre;
    private String descripcion;
    
    public Producto(String nombre, String descripcion){
        this.idProducto = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        id++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }
    
    
    
    public abstract String consultarDatos();
}
