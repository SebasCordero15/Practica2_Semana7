/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author sebas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //// Hacer una simulación para un supermercado
        //
        //En total ingresarán 100 clientes.
        //
        //Cada cliente llega entre 300 a 600 milisegundos, 
        //decide buscar productos de entre 8 a 13 pasillos, en cada pasillos selecciona entre 0 a 6 productos,
        //por cada producto se demora entre 200 a 800 milisegundos, luego de esto se va a hacer fila en la cajera, la cajera se demora entre 20 a 80 milésimas por productos.
        //
        //Debe sacar el total de productos adquiridos por los clientes, el tiempo promedio de estancia de los clientes en el supermercado y el tiempo promedio de atención de la cajera.
        
        Supermercado s= new Supermercado();
        
        ///es igual que el de clase
        
        ExecutorService ejecutor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 82; i++) {
            ejecutor.execute(new Cliente(i, s));
        }
        ejecutor.shutdown();
        while (!ejecutor.isTerminated());
    
        
    }
    }
    
