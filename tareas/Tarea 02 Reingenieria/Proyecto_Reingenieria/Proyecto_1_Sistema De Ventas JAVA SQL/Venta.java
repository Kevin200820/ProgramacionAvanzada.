package UDEMY;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Venta {

    private static int secuencia = 1;

    private int id;
    private LocalDateTime fecha;
    private Cliente cliente;
    private Usuario vendedor;
    private List<DetalleVenta> detalles;
    private double total;
    private String metodoPago;

    public Venta(Cliente cliente, Usuario vendedor, String metodoPago) {
        this.id = secuencia++;
        this.fecha = LocalDateTime.now();
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.metodoPago = metodoPago;
        this.detalles = new ArrayList<>();
        this.total = 0;
    }

    public void agregarDetalle(DetalleVenta detalle) {
        detalles.add(detalle);
        total += detalle.getSubtotal();
    }

    public int getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public Cliente getCliente() { return cliente; }
    public Usuario getVendedor() { return vendedor; }
    public List<DetalleVenta> getDetalles() { return detalles; }
    public double getTotal() { return total; }
    public String getMetodoPago() { return metodoPago; }
}