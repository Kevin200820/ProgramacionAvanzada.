package UDEMY;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;

class PuntoVentaWindow extends JFrame {

    private SistemaVentas sistema;
    private JComboBox<String> cmbClientes;
    private JTextField txtCodigo;
    private DefaultTableModel modelo;
    private JLabel lblTotal;

    private List<DetalleVenta> carrito = new ArrayList<>();
    private Map<Integer, Cliente> mapaClientes = new HashMap<>();

    public PuntoVentaWindow(SistemaVentas sistema) {

        this.sistema = sistema;

        setTitle("Punto de Venta");
        setSize(900,650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10,10));
        add(panelSuperior(),BorderLayout.NORTH);
        add(panelCentro(),BorderLayout.CENTER);
        add(panelInferior(),BorderLayout.SOUTH);
    }

    private JPanel panelSuperior(){

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        panel.add(new JLabel("Cliente:"));

        cmbClientes = new JComboBox<>();
        cargarClientes();

        panel.add(cmbClientes);

        return panel;
    }

    private JPanel panelCentro(){

        JPanel panel = new JPanel(new BorderLayout(10,10));

        JPanel busqueda = new JPanel(new FlowLayout(FlowLayout.LEFT));

        busqueda.add(new JLabel("Código:"));
        txtCodigo = new JTextField(15);
        busqueda.add(txtCodigo);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarProducto());
        busqueda.add(btnAgregar);

        String[] cols = {"Código","Producto","Precio","Cantidad","Subtotal"};

        modelo = new DefaultTableModel(cols,0){
            public boolean isCellEditable(int r,int c){ return false; }
        };

        JTable tabla = new JTable(modelo);

        panel.add(busqueda,BorderLayout.NORTH);
        panel.add(new JScrollPane(tabla),BorderLayout.CENTER);

        return panel;
    }

    private JPanel panelInferior(){

        JPanel panel = new JPanel(new BorderLayout());

        lblTotal = new JLabel("TOTAL: $0.00");
        lblTotal.setFont(new Font("Arial",Font.BOLD,22));

        JButton btnProcesar = new JButton("Procesar");
        JButton btnLimpiar = new JButton("Limpiar");

        btnProcesar.addActionListener(e -> procesarVenta());
        btnLimpiar.addActionListener(e -> limpiar());

        JPanel botones = new JPanel();
        botones.add(btnLimpiar);
        botones.add(btnProcesar);

        panel.add(lblTotal,BorderLayout.NORTH);
        panel.add(botones,BorderLayout.SOUTH);

        return panel;
    }

    private void cargarClientes(){

        for(Cliente c : sistema.listarClientes()){
            cmbClientes.addItem(c.getId()+" - "+c.getNombreCompleto());
            mapaClientes.put(c.getId(),c);
        }
    }

    private void agregarProducto(){

        String codigo = txtCodigo.getText().trim();
        if(codigo.isEmpty()) return;

        Producto p = sistema.buscarProductoPorCodigo(codigo);
        if(p==null){
            JOptionPane.showMessageDialog(this,"Producto no encontrado");
            return;
        }

        int cantidad = 1;

        if(p.getStock() < cantidad){
            JOptionPane.showMessageDialog(this,"Stock insuficiente");
            return;
        }

        DetalleVenta detalle = new DetalleVenta(p,cantidad);
        carrito.add(detalle);

        modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getNombre(),
                String.format("$%.2f",p.getPrecio()),
                cantidad,
                String.format("$%.2f",detalle.getSubtotal())
        });

        actualizarTotal();
        txtCodigo.setText("");
    }

    private void actualizarTotal(){

        double total = 0;
        for(DetalleVenta d : carrito){
            total += d.getSubtotal();
        }

        lblTotal.setText(String.format("TOTAL: $%.2f",total));
    }

    private void procesarVenta(){

        if(carrito.isEmpty()){
            JOptionPane.showMessageDialog(this,"Carrito vacío");
            return;
        }

        String seleccionado = (String) cmbClientes.getSelectedItem();
        int idCliente = Integer.parseInt(seleccionado.split(" - ")[0]);
        Cliente cliente = mapaClientes.get(idCliente);

        sistema.realizarVenta(cliente,carrito,"Efectivo");

        JOptionPane.showMessageDialog(this,"Venta realizada");

        limpiar();
    }

    private void limpiar(){
        carrito.clear();
        modelo.setRowCount(0);
        actualizarTotal();
    }
}