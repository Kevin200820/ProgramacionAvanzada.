package UDEMY;

import javax.swing.*;
import java.awt.*;

class MainWindow extends JFrame {

    private SistemaVentas sistema;
    private JLabel lblUsuario;
    private JLabel lblVentas;

    public MainWindow(SistemaVentas sistema) {

        this.sistema = sistema;

        setTitle("Sistema de Ventas");
        setSize(980, 680);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(crearHeader(), BorderLayout.NORTH);
        add(crearPanelCentral(), BorderLayout.CENTER);
        add(crearFooter(), BorderLayout.SOUTH);

        actualizarResumen();
    }

    private JPanel crearHeader() {

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(41, 128, 185));
        panel.setPreferredSize(new Dimension(900, 80));

        JLabel titulo = new JLabel("SISTEMA DE VENTAS");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JPanel info = new JPanel(new GridLayout(2,1));
        info.setOpaque(false);

        lblUsuario = new JLabel(
                "Usuario: " + sistema.getUsuarioActual().getNombreCompleto());
        lblUsuario.setForeground(Color.WHITE);

        lblVentas = new JLabel("Ventas del dia: 0.00");
        lblVentas.setForeground(Color.WHITE);

        info.add(lblUsuario);
        info.add(lblVentas);

        panel.add(titulo, BorderLayout.WEST);
        panel.add(info, BorderLayout.EAST);

        return panel;
    }

    private JPanel crearPanelCentral() {

        JPanel panel = new JPanel(new GridLayout(2,3,15,15));
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        panel.add(crearBoton("Ventas", e -> abrirVentas()));
        panel.add(crearBoton("Productos", e -> abrirProductos()));
        panel.add(crearBoton("Clientes", e -> abrirClientes()));
        panel.add(crearBoton("Historial", e -> abrirHistorial()));
        panel.add(crearBoton("Reportes", e -> abrirReportes()));
        panel.add(crearBoton("Cerrar Sesion", e -> cerrarSesion()));

        return panel;
    }

    private JButton crearBoton(String texto, java.awt.event.ActionListener accion) {
        JButton btn = new JButton(texto);
        btn.addActionListener(accion);
        return btn;
    }

    private JPanel crearFooter() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Sistema de Ventas Version 1.0"));
        return panel;
    }

    private void actualizarResumen() {
        double total = sistema.calcularVentasDelDia();
        lblVentas.setText("Ventas del dia: " + String.format("%.2f", total));
    }

    private void abrirVentas() {
        new PuntoVentaWindow(sistema, this).setVisible(true);
    }

    private void abrirProductos() {
        new ProductosWindow(sistema).setVisible(true);
    }

    private void abrirClientes() {
        new ClientesWindow(sistema).setVisible(true);
    }

    private void abrirHistorial() {
        new HistorialVentasWindow(sistema).setVisible(true);
    }

    private void abrirReportes() {
        new ReportesWindow(sistema).setVisible(true);
    }

    private void cerrarSesion() {
        sistema.logout();
        dispose();
        new LoginWindow(sistema).setVisible(true);
    }
}