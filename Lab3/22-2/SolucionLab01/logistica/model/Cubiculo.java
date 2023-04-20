package com.librarysoft.logistica.model;
import java.util.ArrayList;
import java.util.Date;
public class Cubiculo{
	private String nombre;
	private int pisoUbicado;
	private int capacidad;
	private boolean tieneTV;
	private boolean tienePizarra;
	private boolean tieneProyector;
	private boolean tieneComputador;
	private ArrayList<Reserva> reservas;
	
	public Cubiculo(String nombre, int pisoUbicado, int capacidad, boolean tieneTV, boolean tienePizarra, boolean tieneProyector, boolean tieneComputador){
		this.nombre = nombre;
		this.pisoUbicado = pisoUbicado;
		this.capacidad = capacidad;
		this.tieneTV = tieneTV;
		this.tienePizarra = tienePizarra;
		this.tieneProyector = tieneProyector;
		this.tieneComputador = tieneComputador;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setReservas(ArrayList<Reserva> reservas){
		this.reservas = reservas;
	}
	
	public void registrarReserva(Reserva reserva){
		this.reservas.add(reserva);
	}
	
	public String consultarReservas(Date fecha){
		String cadena = "";
		for(Reserva reserva : reservas){
			if(reserva.getFecha().equals(fecha)){
				cadena = cadena + reserva.consultarDatos();
			}
		}
		return cadena;
	}
}