public class Videojuego extends Producto{
    private Genero genero;
    private Consola consola;
    private boolean modoUnJugador;
    private boolean modoMultiJugador;
    
    public Videojuego(String nombre, String descripcion, Genero genero, Consola consola, boolean modoUnJugador, boolean modoMultiJugador){
        super(nombre,descripcion);
        this.genero = genero;
        this.consola = consola;
        this.modoUnJugador = modoUnJugador;
        this.modoMultiJugador = modoMultiJugador;
    }

    @Override
    public String consultarDatos() {
        return getIdProducto() + " - " + getNombre() + " - " + genero.getNombre() + " - " + consola.getNombre();
    }
}
