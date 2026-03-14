package Modelo;

import java.io.*;
import java.util.ArrayList;

public class ModeloVenta {
    private ArrayList<Ticket> carrito = new ArrayList<>();
    private final String ARCHIVO_VENTAS = "ventas_historial.txt";

    public void agregarAlCarrito(Ticket linea) {
        carrito.add(linea);
    }

    public double calcularTotalCarrito() {
        double total = 0;
        for (Ticket t : carrito) {
            total += t.getSubtotal();
        }
        return total;
    }

    public void limpiarCarrito() {
        carrito.clear();
    }

    public ArrayList<Ticket> getCarrito() {
        return carrito;
    }

    public void registrarVentaFinal() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_VENTAS, true))) {
            pw.println("--- VENTA ---");
            for (Ticket t : carrito) {
                pw.println(t.getId() + " - " + t.getNombre() + " x" + t.getCantidad() + " $" + t.getSubtotal());
            }
            pw.println("TOTAL: $" + calcularTotalCarrito());
            pw.println("-------------");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}