package com.librarysoft.main;
import java.util.ArrayList;
import java.time.LocalTime;
import java.text.SimpleDateFormat;
import com.librarysoft.logistica.model.Biblioteca;
import com.librarysoft.logistica.model.Cubiculo;
import com.librarysoft.logistica.model.MiembroPUCP;
import com.librarysoft.logistica.model.Reserva;
import com.librarysoft.personal.model.Profesor;
import com.librarysoft.personal.model.Estudiante;
import com.librarysoft.personal.model.Egresado;
import com.librarysoft.personal.model.Categoria;
public class Principal{
	public static void main(String[] args) throws Exception{
		//Objeto SDF
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		//Se crea una biblioteca
		Biblioteca biblioteca1 = new Biblioteca("Biblioteca Central",true);
		//Se crean dos cubículos de la Biblioteca Central
		Cubiculo cub01 = new Cubiculo("101",1,3,true,true,true,true);
		Cubiculo cub02 = new Cubiculo("311",3,3,false,true,false,false);
		//Se asignan los cubículos a la biblioteca
		biblioteca1.setCubiculos(new ArrayList<>());
		biblioteca1.getCubiculos().add(cub01);
		biblioteca1.getCubiculos().add(cub02);
		//Vamos a suponer que un profesor en conjunto con un estudiante y un egresado desean reservar el cubículo 101
		//Se crea a los interesados
		MiembroPUCP persona1 = new Profesor("20022214","JUAN","ARENAS",Categoria.Auxiliar);
		MiembroPUCP persona2 = new Estudiante("20167441","ROSANGELA","VALENZUELA",true);
		MiembroPUCP persona3 = new Egresado("20140445","DANIELA","ARGUMANIS",true);
		//Generamos la reserva para hoy de 10:00 a 11:00
		Reserva reserva1 = new Reserva(sdf.parse("25-08-2022"),LocalTime.of(10,00),LocalTime.of(11,00));
		//Asociamos a los responsables de esta reserva
		reserva1.setResponsables(new ArrayList<>());
		reserva1.getResponsables().add(persona1);
		reserva1.getResponsables().add(persona2);
		reserva1.getResponsables().add(persona3);
		//Inicializamos las reservas del cubiculo 101
		cub01.setReservas(new ArrayList<>());
		//Asociamos la reserva al cubiculo 101
		cub01.registrarReserva(reserva1);
		//Vamos a suponer que un estudiante desea reservar el cubiculo 101 para hoy también pero de 11:00 a 12:00
		MiembroPUCP persona4 = new Estudiante("20135096","ESTEFANI","SILVA",true);
		Reserva reserva2 = new Reserva(sdf.parse("25-08-2022"),LocalTime.of(11,00),LocalTime.of(12,00));
		reserva2.setResponsables(new ArrayList<>());
		reserva2.getResponsables().add(persona4);
		cub01.registrarReserva(reserva2);
		//Ahora consultamos las reservas del cubiculo 101 de la biblioteca para hoy
		String reporte = biblioteca1.consultarReservasDelCubiculo("101",sdf.parse("25-08-2022"));
		System.out.println(reporte);
	}
}