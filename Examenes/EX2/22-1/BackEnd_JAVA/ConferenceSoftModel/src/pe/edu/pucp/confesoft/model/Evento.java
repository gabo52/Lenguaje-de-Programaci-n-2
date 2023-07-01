package pe.edu.pucp.confesoft.model;
import java.util.ArrayList;
import java.util.Date;
public class Evento {
    private int idEvento;
    private ArrayList<Ponencia> ponencias;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private byte[] portada;
    private boolean activo;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public ArrayList<Ponencia> getPonencias() {
        return ponencias;
    }

    public void setPonencias(ArrayList<Ponencia> ponencias) {
        this.ponencias = ponencias;
    }
    
}