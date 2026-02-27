package UDEMY;

import java.time.LocalDateTime;
import java.util.*;

class SistemaVentas {

    private Map<Integer, Producto> productos = new HashMap<>();
    private Map<Integer, Cliente> clientes = new HashMap<>();
    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private List<Venta> ventas = new ArrayList<>();

    private Usuario usuarioActual;
    private int secProducto = 1;
    private int secCliente = 1;

    public SistemaVentas() {
        cargarDatos();
    }

    private void cargarDatos() {

        usuarios.put(1, new Usuario(1, "admin", "admin123", "ADMIN", "Administrador Sistema"));
        usuarios.put(2, new Usuario(2, "vendedor", "vend123", "VENDEDOR", "Juan Pérez"));

        crearProducto("P001", "Laptop Dell", "Core i5", 15000, 10, "Computadoras");
        crearProducto("P002", "Mouse Logitech", "Inalámbrico", 1200, 50, "Accesorios");

        crearCliente("María", "González", "123456789", "maria@email.com", "Centro");
        crearCliente("Carlos", "Rodríguez", "987654321", "carlos@email.com", "Norte");
    }

    public Usuario login(String user, String pass) {
        for (Usuario u : usuarios.values()) {
            if (u.getUsername().equals(user) && u.getPassword().equals(pass)) {
                usuarioActual = u;
                return u;
            }
        }
        return null;
    }

    public void logout() { usuarioActual = null; }

    public Producto crearProducto(String codigo, String nombre,
                                   String descripcion, double precio,
                                   int stock, String categoria) {

        Producto p = new Producto(secProducto++, codigo, nombre,
                descripcion, precio, stock, categoria);

        productos.put(p.getId(), p);
        return p;
    }

    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }

    public Producto buscarProductoPorCodigo(String codigo) {
        for (Producto p : productos.values()) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
        }
        return null;
    }

    public boolean actualizarProducto(Producto p) {
        if (!productos.containsKey(p.getId())) return false;
        productos.put(p.getId(), p);
        return true;
    }

    public boolean eliminarProducto(int id) {
        return productos.remove(id) != null;
    }

    public Cliente crearCliente(String nombre, String apellido,
                                String telefono, String email,
                                String direccion) {

        Cliente c = new Cliente(secCliente++, nombre, apellido,
                telefono, email, direccion);

        clientes.put(c.getId(), c);
        return c;
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }

    public Venta realizarVenta(Cliente cliente,
                               List<DetalleVenta> detalles,
                               String metodoPago) {

        for (DetalleVenta d : detalles) {
            if (d.getProducto().getStock() < d.getCantidad()) {
                throw new RuntimeException("Stock insuficiente");
            }
        }

        Venta v = new Venta(cliente, usuarioActual, metodoPago);

        for (DetalleVenta d : detalles) {
            v.agregarDetalle(d);
            Producto p = d.getProducto();
            p.setStock(p.getStock() - d.getCantidad());
        }

        ventas.add(v);
        return v;
    }

    public List<Venta> listarVentas() {
        return new ArrayList<>(ventas);
    }

    public double ventasDelDia() {
        LocalDateTime hoy = LocalDateTime.now();
        return ventas.stream()
                .filter(v -> v.getFecha().toLocalDate().equals(hoy.toLocalDate()))
                .mapToDouble(Venta::getTotal)
                .sum();
    }
}