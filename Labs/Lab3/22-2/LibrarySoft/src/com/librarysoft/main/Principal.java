package com.librarysoft.main;
import com.librarysoft.logistica.dao.BibliotecaDAO;
import com.librarysoft.logistica.model.Biblioteca;
import com.librarysoft.logistica.mysql.BibliotecaMySQL;
import java.time.LocalTime;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args){
        //Se generan los objetos
        Biblioteca bib01 = new Biblioteca("Biblioteca Central Luis Jaime Cisneros",LocalTime.of(9,00),LocalTime.of(20,00),true);
        Biblioteca bib02 = new Biblioteca("Biblioteca del Instituto RivaAgüero",LocalTime.of(7,00),LocalTime.of(17,00),false);
        //Se crea el DAO de conexión
        BibliotecaDAO daoBiblioteca = new BibliotecaMySQL();
       //Se registran las bibliotecas
        int resultado;
        resultado = daoBiblioteca.insertar(bib01);
        System.out.println(evaluarResultado(resultado,bib01.getNombre()));
        resultado = daoBiblioteca.insertar(bib02);
        System.out.println(evaluarResultado(resultado,bib02.getNombre()));
        //Se consultan las bibliotecas desde base de datos
        ArrayList<Biblioteca> bibliotecas = daoBiblioteca.listarTodas();
        //Se imprimen
        for(Biblioteca bib : bibliotecas){
            System.out.println(bib.devolverDatos());
        }
    }
 
    public static String evaluarResultado(int resultado, String nombre){
       String cadena;
       if(resultado == 1)
       cadena = "Se ha registrado con éxito la biblioteca: " + nombre;
       else
       cadena = "Ha fallado el registro de la biblioteca: " + nombre;
       return cadena;
    }
}

