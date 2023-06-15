package pe.edu.pucp.cinemasoft.model;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
public class Pelicula {
    private int idPelicula;
    private Genero genero;
    private ArrayList<Actor> actores;
    private String titulo;
    private Date fechaEstreno;
    private Time duracion;
    private boolean disponibleSubtitulada;
    private boolean disponibleDoblada;
    private String sinopsis;
    private byte[] portada;
    private boolean activo;

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public boolean isDisponibleSubtitulada() {
        return disponibleSubtitulada;
    }

    public void setDisponibleSubtitulada(boolean disponibleSubtitulada) {
        this.disponibleSubtitulada = disponibleSubtitulada;
    }

    public boolean isDisponibleDoblada() {
        return disponibleDoblada;
    }

    public void setDisponibleDoblada(boolean disponibleDoblada) {
        this.disponibleDoblada = disponibleDoblada;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public byte[] getPortada() {
        return portada;
    }

    public void setPortada(byte[] portada) {
        this.portada = portada;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }
    
}