package com.gamesoft.project.model;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.avatar.rrhh.model.Colaborador;
import com.avatar.rrhh.model.Persona;
public class Proyecto {
    private static int id = 1;
    private int idProyecto;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private EstadoProyecto estado;
    private Producto producto;
    private ArrayList<Colaborador> colaboradores;
    private Persona responsable;
    
    public Proyecto(String nombre, Date fechaInicio, Date fechaFin, EstadoProyecto estado){
        idProyecto = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
        id++;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(ArrayList<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }
    
    public String generarReporte(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String reporte = "";
        String separador = "--------------------------------------------------------"+"\n";
        reporte += "ID del Proyecto: " + idProyecto + "\n";
        reporte += "Nombre: " + nombre + "\n";
        reporte += "Fecha Inicio: " + sdf.format(fechaInicio) + "\n";
        reporte += "Fecha Fin: " + sdf.format(fechaFin) + "\n";
        reporte += separador;
        reporte += "Producto a desarrollar: " + "\n";
        reporte += producto.consultarDatos() + "\n";
        reporte += separador;
        reporte += "Responsable: " + "\n";
        reporte += responsable.consultarDatos() + "\n";
        reporte += separador;
        reporte += "Colaboradores: " + "\n";
        for(Colaborador colab : colaboradores)
            reporte += colab.consultarDatos() + "\n";
        return reporte;
    }
}