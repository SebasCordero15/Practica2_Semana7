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
    public int idCliente;
    Supermercado supermercado;
    public static int nPasillos = 5;
    static Semaphore semaforo = new Semaphore(nPasillos);

    public Cliente(int idCliente, Supermercado supermercado) {
        this.idCliente = idCliente;
        this.supermercado = supermercado;
    }
    
    @Override
    public void run(){
        try{
           semaforo.acquire();
           this.supermercado.comprarProducto(this.idCliente);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        semaforo.release();
    }
}