/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilos;

/**
 *
 * @author gabri
 */

public class Hilos implements Runnable{
    public static void main(String[] args) throws Exception{
        Runnable e = new Hilos();
        Thread t = new Thread(e,"Hilo 1");
        t.start();
        System.out.print(t.getName());
        System.out.println(", estado = " + t.isAlive());
    }
    @Override
    public void run(){
        Thread t = Thread.currentThread();
        System.out.print(t.getName());
        System.out.println(", estado = " + t.isAlive());
    } 
}
