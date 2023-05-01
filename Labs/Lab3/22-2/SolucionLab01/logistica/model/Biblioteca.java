package com.librarysoft.logistica.model;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
public class Biblioteca{
	private int idBiblioteca;
	private String nombre;
	private LocalTime horaApertura;
	private LocalTime horaCierre;
	private boolean ubicadaEnCampus;
	private ArrayList<Cubiculo> cubiculos;
	private boolean activa;
	
	public Biblioteca(){}
	
	public Biblioteca(String nombre, boolean ubicadaEnCampus){
		this.nombre = nombre;
		this.ubicadaEnCampus = ubicadaEnCampus;
	}
	
	public Biblioteca(String nombre, LocalTime horaApertura, LocalTime horaCierre, boolean ubicadaEnCampus){
		this.nombre = nombre;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.ubicadaEnCampus = ubicadaEnCampus;
	}
	
	public Biblioteca(int idBiblioteca, String nombre, LocalTime horaApertura, LocalTime horaCierre, boolean ubicadaEnCampus, boolean activa){
		this.idBiblioteca = idBiblioteca;
		this.nombre = nombre;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.ubicadaEnCampus = ubicadaEnCampus;
		this.activa = activa;
	}
	
	public int getIdBiblioteca(){
		return idBiblioteca;
	}
	
	public void setIdBiblioteca(int idBiblioteca){
		this.idBiblioteca = idBiblioteca;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setHoraApertura(LocalTime horaApertura){
		this.horaApertura = horaApertura;
	}
	
	public LocalTime getHoraApertura(){
		return horaApertura;
	}
	
	public void setHoraCierre(LocalTime horaCierre){
		this.horaCierre = horaCierre;
	}
	
	public LocalTime getHoraCierre(){
		return horaCierre;
	}
	
	public void setCubiculos(ArrayList<Cubiculo> cubiculos){
		this.cubiculos = cubiculos;
	}
	
	public ArrayList<Cubiculo> getCubiculos(){
		return cubiculos;
	}
	
	public boolean isUbicadaEnCampus(){
		return ubicadaEnCampus;
	}
	
	public void setUbicadaEnCampus(boolean ubicadaEnCampus){
		this.ubicadaEnCampus = ubicadaEnCampus;
	}
	
	public boolean isActiva(){
		return activa;
	}
	
	public void setActiva(boolean activa){
		this.activa = activa;
	}
	
	public String consultarReservasDelCubiculo(String nombre, Date fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String cadena = "Reservas del cubiculo " + nombre + " de la " + this.nombre + " para "+ sdf.format(fecha) + "\n";
		for(Cubiculo cubiculo: cubiculos){
			if(cubiculo.getNombre() == nombre){
				cadena = cadena + cubiculo.consultarReservas(fecha);
			}
		}
		return cadena;
	}

	public String devolverDatos(){
		return idBiblioteca + ". " + nombre + ", Hora Apertura: " + horaApertura + ", Hora Cierre: " + horaCierre + " - Ubicada en Campus: " + (ubicadaEnCampus?"SI":"NO");
	}
}