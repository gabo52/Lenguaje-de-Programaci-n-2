package com.gamesoft.main;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import com.avatar.rrhh.model.Colaborador;
import com.avatar.rrhh.model.Persona;
import com.avatar.rrhh.model.Organizacion;

import com.gamesoft.project.model.Genero;
import com.gamesoft.project.model.Videojuego;
import com.gamesoft.project.model.Consola;
import com.gamesoft.project.model.Proyecto;
import com.gamesoft.project.model.TipoConectividad;
import com.gamesoft.project.model.EstadoProyecto;

public class Principal {
    public static void main(String[] args) throws Exception{
        //Se crean dos colaboradores de tipo organización
        Colaborador colab1 = new Organizacion("19827220391", "EPIC GAMES", "6262002", "Av. Javier Prado 1092 - San Isidro");
        Colaborador colab2 = new Organizacion("12398371102", "ACTIVISION BLIZZARD", "6230994", "Av. Javier Prado 1092 - San Isidro");
        //Se crean dos colaboradores de tipo persona
        Colaborador colab3 = new Persona("64190101", "GABE", "NEWELL", "941872298", "Av. Universitaria 2918 - Pueblo Libre");
        Colaborador colab4 = new Persona("23421209", "BILL", "GATES", "938739911", "Av. La Mar 1183 - San Miguel");
        //Se crea una persona
        Persona pers1 = new Persona("23982109","SHIGERU","MIYAMOTO","983728827","Av. Gregorio Escobedo 2093 - Breña");
        //Se registra una consola que ha creado previamente la empresa
        Consola cons1 = new Consola("PLAYSTATION 5", "Consola de última generación con gráficos 4K", 1000, 4, TipoConectividad.WIFI);
        //Se registra el género del videojuego que desea desarrollar la empresa
        Genero gen1 = new Genero("ARPG", "Videojuegos de rol de acción que se caracterizan por ofrecer combates en tiempo real.");
        //Se registra el videojuego que desea desarrollar la empresa en el proyecto que será del género y para la consola previamente creada
        Videojuego videojuego = new Videojuego("GENSHIM IMPACT", "Videojuego de acción de mundo abierto con una mecánica de monetización de Gacha", gen1, cons1, true, true);
        //Se registra el proyecto
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Proyecto proj1 = new Proyecto("Desarrollo de videojuego mundo abierto GI",sdf.parse("22-04-2022"),sdf.parse("31-03-2024"),EstadoProyecto.Definido);
        //Se asigna el videojuego que se desea desarrollar en el proyecto
        proj1.setProducto(videojuego);
        //Se asignan los colaboradores del proyecto
        proj1.setColaboradores(new ArrayList<>());
        proj1.getColaboradores().add(colab1);
        proj1.getColaboradores().add(colab2);
        proj1.getColaboradores().add(colab3);
        proj1.getColaboradores().add(colab4);
        //Se asigna al responsable
        proj1.setResponsable(pers1);
        //Se genera un reporte del proyecto
        String reporte = proj1.generarReporte();
        //Se imprime el reporte
        System.out.println(reporte);
    }
}