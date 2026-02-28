package Parte2MVC;

import Parte2.Insumo;
import Parte2.Categoria;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ControladorInsumos implements ActionListener {
    private VistaInsumos vista;
    private ModeloInsumos modelo;

    public ControladorInsumos(VistaInsumos vista, ModeloInsumos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.bagregar.addActionListener(this);
        this.vista.beliminar.addActionListener(this);
        this.vista.bsalir.addActionListener(this);
        volverInicio();
    }

    private void volverInicio() {
        vista.bagregar.setText("Agregar");
        vista.bsalir.setText("Salir");
        vista.beliminar.setEnabled(true);
        vista.tid.setEditable(false);
        vista.tinsumo.setEditable(false);
        vista.comboCategoria.setEnabled(false);
        vista.tid.setText("");
        vista.tinsumo.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.bagregar) {
            if (vista.bagregar.getText().equals("Agregar")) {
                prepararAlta();
            } else {
                guardarInsumo();
            }
        } else if (e.getSource() == vista.beliminar) {
            eliminarInsumo();
        } else if (e.getSource() == vista.bsalir) {
            if (vista.bsalir.getText().equals("Cancelar")) volverInicio();
            else vista.dispose();
        }
    }

    private void prepararAlta() {
        vista.bagregar.setText("Salvar");
        vista.bsalir.setText("Cancelar");
        vista.beliminar.setEnabled(false);
        vista.tid.setEditable(true);
        vista.tinsumo.setEditable(true);
        vista.comboCategoria.setEnabled(true);
    }

    private void guardarInsumo() {
        Categoria cat = (Categoria) vista.comboCategoria.getSelectedItem();
        Insumo nuevo = new Insumo(vista.tid.getText(), vista.tinsumo.getText(), cat.getIdcategoria());
        
        if (modelo.getListaInsumos().agregarInsumo(nuevo)) {
            vista.areaProductos.setText(modelo.getListaInsumos().toString());
            volverInicio();
        } else {
            JOptionPane.showMessageDialog(vista, "El ID ya existe.");
        }
    }

    private void eliminarInsumo() {
        Object[] ids = modelo.getListaInsumos().idinsumos();
        if (ids.length == 0) return;
        
        String seleccion = (String) JOptionPane.showInputDialog(vista, "Seleccione ID:", 
                "Eliminar", JOptionPane.PLAIN_MESSAGE, null, ids, ids[0]);
        
        if (seleccion != null) {
            modelo.getListaInsumos().eliminarInsumoPorId(seleccion);
            vista.areaProductos.setText(modelo.getListaInsumos().toString());
        }
    }
}