package pe.edu.servicesoft.model;

import java.util.Date;



public class Servicio {
    private static int idServicio=1;
    private String nombre;
    private String descripcion;
    private double costo;
    private int relevancia;
    private Date fecha;
    private char estado;

    
    public Servicio(){};
    public Servicio(String nombre, String descripcion, double costo, int relevancia, Date fecha, char estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.relevancia = relevancia;
        this.fecha = fecha;
        this.estado = estado;
        this.idServicio=idServicio;
        idServicio++;
    }

    public Servicio(int idServicio, String nombre, String descripcion, double costo, int relevancia, Date fecha, char estado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.relevancia = relevancia;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setRelevancia(int relevancia) {
        this.relevancia = relevancia;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public int getRelevancia() {
        return relevancia;
    }

    public Date getFecha() {
        return fecha;
    }

    public char getEstado() {
        return estado;
    }
    
    
}