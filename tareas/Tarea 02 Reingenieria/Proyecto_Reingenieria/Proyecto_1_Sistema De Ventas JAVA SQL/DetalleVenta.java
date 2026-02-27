package UDEMY;

class DetalleVenta {

    private Producto producto;
    private int cantidad;
    private double totalLinea;

    public DetalleVenta(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.totalLinea = calcularTotal();
    }

    private double calcularTotal() {
        return producto.getPrecio() * cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getTotalLinea() { return totalLinea; }
}