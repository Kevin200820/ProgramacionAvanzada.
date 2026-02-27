package UDEMY;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class ClientesWindow extends JFrame {

    private SistemaVentas sistema;
    private DefaultTableModel modelo;
    private JTable tablaClientes;

    public ClientesWindow(SistemaVentas sistema) {

        this.sistema = sistema;

        setTitle("Administracion de Clientes");
        setSize(880, 580);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        add(crearPanelBotones(), BorderLayout.NORTH);
        add(crearTabla(), BorderLayout.CENTER);

        cargarClientes();
    }

    private JPanel crearPanelBotones() {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnNuevo = new JButton("Agregar");
        JButton btnRecargar = new JButton("Recargar");

        btnNuevo.addActionListener(e -> mostrarFormulario());
        btnRecargar.addActionListener(e -> cargarClientes());

        panel.add(btnNuevo);
        panel.add(btnRecargar);

        return panel;
    }

    private JScrollPane crearTabla() {

        String[] columnas = {
                "Codigo", "Nombres", "Apellidos",
                "Telefono", "Correo", "Direccion"
        };

        modelo = new DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int fila, int columna) {
                return false;
            }
        };

        tablaClientes = new JTable(modelo);
        return new JScrollPane(tablaClientes);
    }

    private void cargarClientes() {

        modelo.setRowCount(0);

        for (Cliente c : sistema.listarClientes()) {
            modelo.addRow(new Object[]{
                    c.getCodigo(),
                    c.getNombres(),
                    c.getApellidos(),
                    c.getTelefono(),
                    c.getCorreo(),
                    c.getDireccion()
            });
        }
    }

    private void mostrarFormulario() {

        JTextField nombres = new JTextField();
        JTextField apellidos = new JTextField();
        JTextField telefono = new JTextField();
        JTextField correo = new JTextField();
        JTextField direccion = new JTextField();

        Object[] campos = {
                "Nombres:", nombres,
                "Apellidos:", apellidos,
                "Telefono:", telefono,
                "Correo:", correo,
                "Direccion:", direccion
        };

        int opcion = JOptionPane.showConfirmDialog(
                this,
                campos,
                "Nuevo Cliente",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (opcion == JOptionPane.OK_OPTION) {

            if (nombres.getText().trim().isEmpty() ||
                apellidos.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(this,
                        "Debe ingresar nombres y apellidos");
                return;
            }

            sistema.crearCliente(
                    nombres.getText(),
                    apellidos.getText(),
                    telefono.getText(),
                    correo.getText(),
                    direccion.getText()
            );

            cargarClientes();
        }
    }
}
