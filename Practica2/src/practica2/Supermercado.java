/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

/**
 *
 * @author indir
 */
public class Supermercado {
    //1. Cada cliente llega entre 300 a 600 milisegundos,
            //generar el tiempo de llegada del cliente
        

        
    ///igual que el de clase
     public void visitarPasillo(int idCliente){
         long tiempoLlegada = (long) (Math.random() *(600-300))+300;
        
        try{
            System.out.println("El cliente "+ idCliente+ "acaba de entrar al pasillo ");
            Thread.sleep(tiempoLlegada);
            System.out.println("El cliente "+ idCliente+ "ha terminado  tiempo "+ tiempoLlegada);
        }catch(InterruptedException e){
            System.out.println("Hubo un problema probandose la ropa");
        }
    }
}
