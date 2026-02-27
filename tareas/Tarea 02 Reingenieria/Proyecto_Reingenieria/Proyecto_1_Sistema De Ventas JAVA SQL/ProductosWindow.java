package UDEMY;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

class ProductosWindow extends JFrame {

    private SistemaVentas sistema;
    private JTable tabla;
    private DefaultTableModel modelo;

    public ProductosWindow(SistemaVentas sistema) {

        this.sistema = sistema;

        setTitle("Gestión de Productos");
        setSize(950, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10,10));
        add(panelBotones(), BorderLayout.NORTH);
        add(panelTabla(), BorderLayout.CENTER);

        cargarDatos();
    }

    private JPanel panelBotones() {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnNuevo = new JButton("Nuevo");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Actualizar");

        btnNuevo.addActionListener(e -> nuevoProducto());
        btnEditar.addActionListener(e -> editarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnRefrescar.addActionListener(e -> cargarDatos());

        panel.add(btnNuevo);
        panel.add(btnEditar);
        panel.add(btnEliminar);
        panel.add(btnRefrescar);

        return panel;
    }

    private JScrollPane panelTabla() {

        String[] columnas = {
                "ID","Código","Nombre",
                "Descripción","Precio",
                "Stock","Categoría"
        };

        modelo = new DefaultTableModel(columnas,0){
            public boolean isCellEditable(int r,int c){ return false; }
        };

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        return new JScrollPane(tabla);
    }

    private void cargarDatos() {

        modelo.setRowCount(0);

        List<Producto> lista = sistema.listarProductos();

        for (Producto p : lista) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getCodigo(),
                    p.getNombre(),
                    p.getDescripcion(),
                    String.format("$%.2f", p.getPrecio()),
                    p.getStock(),
                    p.getCategoria()
            });
        }
    }

    private void nuevoProducto() {

        JTextField codigo = new JTextField();
        JTextField nombre = new JTextField();
        JTextField descripcion = new JTextField();
        JTextField precio = new JTextField();
        JTextField stock = new JTextField();
        JTextField categoria = new JTextField();

        Object[] campos = {
                "Código:", codigo,
                "Nombre:", nombre,
                "Descripción:", descripcion,
                "Precio:", precio,
                "Stock:", stock,
                "Categoría:", categoria
        };

        int op = JOptionPane.showConfirmDialog(
                this, campos, "Nuevo Producto",
                JOptionPane.OK_CANCEL_OPTION);

        if (op == JOptionPane.OK_OPTION) {

            try {
                sistema.crearProducto(
                        codigo.getText(),
                        nombre.getText(),
                        descripcion.getText(),
                        Double.parseDouble(precio.getText()),
                        Integer.parseInt(stock.getText()),
                        categoria.getText()
                );

                cargarDatos();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Datos inválidos");
            }
        }
    }

    private void editarProducto() {

        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione un producto");
            return;
        }

        int id = (int) modelo.getValueAt(fila,0);
        Producto p = sistema.buscarProductoPorId(id);

        JTextField precio = new JTextField(String.valueOf(p.getPrecio()));
        JTextField stock = new JTextField(String.valueOf(p.getStock()));

        Object[] campos = {
                "Precio:", precio,
                "Stock:", stock
        };

        int op = JOptionPane.showConfirmDialog(
                this, campos, "Editar Producto",
                JOptionPane.OK_CANCEL_OPTION);

        if (op == JOptionPane.OK_OPTION) {
            try {
                p.setPrecio(Double.parseDouble(precio.getText()));
                p.setStock(Integer.parseInt(stock.getText()));
                sistema.actualizarProducto(p);
                cargarDatos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Valores inválidos");
            }
        }
    }

    private void eliminarProducto() {

        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this,"Seleccione un producto");
            return;
        }

        int id = (int) modelo.getValueAt(fila,0);

        int confirm = JOptionPane.showConfirmDialog(
                this,"¿Eliminar producto?",
                "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            sistema.eliminarProducto(id);
            cargarDatos();
        }
    }
}