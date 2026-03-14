package Modelo;

public class Ticket extends Producto {
    private int cantidad;
    private double subtotal;

    public Ticket(String id, String nombre, double precio, String estado, int cantidad) {
        super(id, nombre, precio, estado);
        this.cantidad = cantidad;
        this.subtotal = precio * cantidad;
    }

    public int getCantidad() { return cantidad; }
    public double getSubtotal() { return subtotal; }
}