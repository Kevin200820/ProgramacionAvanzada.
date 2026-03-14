package Controlador;

import Modelo.*;
import Vista.VistaVenta;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ControladorVenta implements ActionListener {
    private ModeloTienda inventario;
    private ModeloVenta modeloVenta;
    private VistaVenta vista;

    public ControladorVenta(ModeloTienda inv, ModeloVenta mv, VistaVenta vv) {
        this.inventario = inv;
        this.modeloVenta = mv;
        this.vista = vv;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnQuitar.addActionListener(this);
        this.vista.btnFinalizar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            Producto p = inventario.buscar(vista.txtIdBusqueda.getText());
            if (p != null) {
                int cant = Integer.parseInt(vista.txtCantidad.getText());
                modeloVenta.agregarAlCarrito(new Ticket(p.getId(), p.getNombre(), p.getPrecio(), p.getEstado(), cant));
                actualizar();
            }
        }
        if (e.getSource() == vista.btnQuitar) {
            int fila = vista.tablaCarrito.getSelectedRow();
            if (fila >= 0) {
                modeloVenta.getCarrito().remove(fila);
                actualizar();
            }
        }
        if (e.getSource() == vista.btnFinalizar) {
            modeloVenta.registrarVentaFinal();
            modeloVenta.limpiarCarrito();
            actualizar();
            JOptionPane.showMessageDialog(vista, "Venta Guardada");
        }
    }

    private void actualizar() {
        vista.modeloTabla.setRowCount(0);
        for (Ticket t : modeloVenta.getCarrito()) {
            vista.modeloTabla.addRow(new Object[]{t.getId(), t.getNombre(), t.getCantidad(), t.getPrecio(), t.getSubtotal()});
        }
        vista.txtTotal.setText(String.valueOf(modeloVenta.calcularTotalCarrito()));
    }
}