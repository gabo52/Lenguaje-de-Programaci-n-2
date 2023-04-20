package com.librarysoft.logistica.model;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalTime;
public class Reserva implements IConsultable{
	private static int correlativo = 1;
	private int id;
	private Date fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private ArrayList<MiembroPUCP> responsables;
	
	public Reserva(Date fecha, LocalTime horaInicio, LocalTime horaFin){
		this.id = correlativo;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		correlativo++;
	}
	
	public void setResponsables(ArrayList<MiembroPUCP> responsables){
		this.responsables = responsables;
	}
	
	public ArrayList<MiembroPUCP> getResponsables(){
		return responsables;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public String consultarDatos(){
		String cadena = "";
		cadena = cadena + "Reserva " + id + ": " + "de " + horaInicio + " a " + horaFin + "\n";
		for(MiembroPUCP miembroPUCP : responsables){
			cadena = cadena + "\t" + miembroPUCP.consultarDatos() + "\n";
		}
		return cadena;
	}
}