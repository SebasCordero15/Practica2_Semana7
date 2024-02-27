/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author indir
 */
public class Cliente implements Runnable{
    int idCliente;
    Supermercado supermercado;
    static int pasillos= 5;
     static Semaphore semaforo=new Semaphore(pasillos);
      long tiempo_producto= (long) (Math.random() *(400-200))+800;
      int producto;
      

    public Cliente(int id, Supermercado mercado) {
        this.idCliente = id;
        this.supermercado = mercado;
    }
     
      
    //igual que el de clase
    @Override
    public void run(){
        try{
            /*
            si el num de vestidores es mayor que cero
            permite el acceso al cliente
            */
            semaforo.acquire();
            this.supermercado.visitarPasillo(idCliente);
        }catch(InterruptedException e){
            System.out.println("El hilo ha sido interrumpido");
        }
        //quita el persimo para que el user entre al vestidor
        semaforo.release();
    }
    
              
}
