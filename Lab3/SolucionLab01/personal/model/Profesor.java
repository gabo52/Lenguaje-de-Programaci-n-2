package com.librarysoft.personal.model;
import com.librarysoft.logistica.model.MiembroPUCP;

public class Profesor extends MiembroPUCP{
	private Categoria categoria;
	public Profesor(String codigoPUCP, String nombre, String apellidoPaterno, Categoria categoria){
		super(codigoPUCP, nombre, apellidoPaterno);
		this.categoria = categoria;
	}
	@Override
	public String consultarDatos(){
		return "Profesor(a): " + getCodigoPUCP() + " - " + getNombre() + " " + getApellidoPaterno() + " - " + categoria;
	}
}