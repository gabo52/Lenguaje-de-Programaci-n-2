package com.librarysoft.personal.model;
import com.librarysoft.logistica.model.MiembroPUCP;
public class Estudiante extends MiembroPUCP{
	private boolean estaMatriculado;
	public Estudiante(String codigoPUCP, String nombre, String apellidoPaterno, boolean estaMatriculado){
		super(codigoPUCP, nombre, apellidoPaterno);
		this.estaMatriculado = estaMatriculado;
	}
	@Override
	public String consultarDatos(){
		return "Estudiante: " + getCodigoPUCP() + " - " + getNombre() + " " + getApellidoPaterno() + " - Matriculado(a): " + estaMatriculado;
	}
}