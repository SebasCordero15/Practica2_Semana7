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
    static long TiempoCajaPromedio = 0;
    static long cantidadClientes = 0;
    static long tiempoPromedio = 0;
    static long productoTotal = 0;
    

    public void comprarProducto(int idCliente) {
        long tiempoLlegada = (long) ((Math.random() * 301) + 300); //1. tiempo de llegada  de los clientes 
        long pasillos = (long) ((Math.random() * 6) + 8); //2. Asigna un pasillo de 8 -13

        try {
            cantidadClientes++;  // se suma la cantidad de clientes
            System.out.println("\nEl cliente con el ID " + idCliente + " acaba de llegar al supermercado ");
            Thread.sleep(tiempoLlegada);
            tiempoPromedio += tiempoLlegada;
            System.out.println("\nEl cliente " + idCliente + " escogio el pasillo numero " + pasillos);
            long producto_Cantidad = 0;
            for (int i = 8; i < 14; i++) {   // el cliente recorre todos los pasillos

                long productos = (long) (Math.random() * 7); ///3
                long tiempoEnPasillos = (long) ((Math.random() * 200) + 250);
                System.out.println("\nEl cliente " + idCliente + " ingreso  al pasillo " + i);

                Thread.sleep(tiempoEnPasillos);
                System.out.println("\nEl cliente " + idCliente + " eligio " + productos + " producto(s) en el pasillo " + i
                + " y duro un total de " + tiempoEnPasillos+ " milisegundos.");
                producto_Cantidad += productos; //La cantidad de productos elegidos se va sumando
                productoTotal += productos;
                tiempoPromedio += tiempoEnPasillos;
            }
            
            System.out.println("\nEl cliente " + idCliente + "  finalizo sus compras  y ahora  se dirige a caja.");
            long tiempoProductos = (long) (((Math.random() * 201) + 600) * producto_Cantidad); //4
            Thread.sleep(tiempoProductos);
            tiempoPromedio += tiempoProductos;
            System.out.println("\nEl cliente " + idCliente + " pago sus " + producto_Cantidad + " productos.");
            TiempoCajaPromedio += tiempoProductos;
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Totales() {
        System.out.println("\n------------- TOTALES --------------" 
                +"\nSe compraron un total de " + productoTotal+ " productos entre todos los clientes"
                + "\nEl tiempo promedio de permanencia de los clientes en el supermercado fue " + (tiempoPromedio / cantidadClientes)
                + " milisegundos"
                + "\nEl tiempo promedio de la atencion de la cajera es de " + (TiempoCajaPromedio / cantidadClientes) 
                + " milisegundos");
    }

}
