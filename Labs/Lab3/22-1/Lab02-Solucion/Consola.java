public class Consola extends Producto{
    private int capacidad;
    private int nroNucleos;
    private TipoConectividad tipoConectividad;
    
    public Consola(String nombre, String descripcion, int capacidad, int nroNucleos, TipoConectividad tipoConectividad){
        super(nombre, descripcion);
        this.capacidad = capacidad;
        this.nroNucleos = nroNucleos;
        this.tipoConectividad = tipoConectividad;
    }

    @Override
    public String consultarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
