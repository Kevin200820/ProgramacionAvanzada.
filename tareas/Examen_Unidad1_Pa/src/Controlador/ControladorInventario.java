package Controlador;

import Modelo.*;
import Vista.VistaTienda;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ControladorInventario implements ActionListener {
    private ModeloTienda modelo;
    private VistaTienda vista;

    public ControladorInventario(ModeloTienda m, VistaTienda v) {
        this.modelo = m;
        this.vista = v;
        this.vista.btnCrear.addActionListener(this);
        this.vista.btnConsultar.addActionListener(this);
        this.vista.btnModificar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnLimpiar.addActionListener(this);
        llenarTabla();
    }

    public void llenarTabla() {
        vista.modeloTabla.setRowCount(0);
        for (Producto p : modelo.listaProductos) {
            vista.modeloTabla.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getEstado()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String id = vista.txtId.getText();
            String nom = vista.txtNombre.getText();
            String est = vista.rbDisponible.isSelected() ? "Disponible" : "Agotado";

            if (e.getSource() == vista.btnCrear) {
                if (modelo.existe(id)) {
                    JOptionPane.showMessageDialog(vista, "ID Duplicado");
                } else {
                    double pre = Double.parseDouble(vista.txtPrecio.getText());
                    modelo.insertar(new Producto(id, nom, pre, est));
                }
            }

            if (e.getSource() == vista.btnConsultar) {
                Producto p = modelo.buscar(id);
                if (p != null) {
                    vista.txtNombre.setText(p.getNombre());
                    vista.txtPrecio.setText(String.valueOf(p.getPrecio()));
                    if (p.getEstado().equals("Disponible")) vista.rbDisponible.setSelected(true);
                    else vista.rbAgotado.setSelected(true);
                }
            }

            if (e.getSource() == vista.btnModificar) {
                double pre = Double.parseDouble(vista.txtPrecio.getText());
                modelo.actualizar(id, nom, pre, est);
            }

            if (e.getSource() == vista.btnEliminar) {
                modelo.eliminar(id);
            }

            if (e.getSource() == vista.btnLimpiar) {
                vista.txtId.setText("");
                vista.txtNombre.setText("");
                vista.txtPrecio.setText("");
            }

            llenarTabla();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error en datos");
        }
    }
} 