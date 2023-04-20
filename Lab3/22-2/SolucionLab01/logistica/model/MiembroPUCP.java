package com.librarysoft.logistica.model;
public abstract class MiembroPUCP implements IConsultable{
	private String codigoPUCP;
	private String nombre;
	private String apellidoPaterno;
	
	public MiembroPUCP(String codigoPUCP, String nombre, String apellidoPaterno){
		this.codigoPUCP = codigoPUCP;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getCodigoPUCP(){
		return codigoPUCP;
	}
	public String getNombre(){
		return nombre;
	}
	public String getApellidoPaterno(){
		return apellidoPaterno;
	}
	public abstract String consultarDatos();
}