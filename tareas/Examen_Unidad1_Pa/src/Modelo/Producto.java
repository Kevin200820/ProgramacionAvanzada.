package Modelo;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private String estado;

    public Producto(String id, String nombre, double precio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.estado = estado;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getEstado() { return estado; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setEstado(String estado) { this.estado = estado; }

    @Override
    public String toString() {
        return id + "," + nombre + "," + precio + "," + estado;
    }
}