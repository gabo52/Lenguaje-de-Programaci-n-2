package com.librarysoft.personal.model;
import com.librarysoft.logistica.model.MiembroPUCP;
public class Egresado extends MiembroPUCP{
	private boolean esTitulado;
	public Egresado(String codigoPUCP, String nombre, String apellidoPaterno, boolean esTitulado){
		super(codigoPUCP, nombre, apellidoPaterno);
		this.esTitulado = esTitulado;
	}
	@Override
	public String consultarDatos(){
		return "Egresado(a): " + getCodigoPUCP() + " - " + getNombre() + " " + getApellidoPaterno() + " - Titulado(a): " + esTitulado;
	}
}