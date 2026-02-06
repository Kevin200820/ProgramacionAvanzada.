package controlador;

import modelo.FormularioModelo;
import vista.FormularioVista;

import javax.swing.*;

public class FormularioControlador {

    private FormularioModelo modelo;
    private FormularioVista vista;

    public FormularioControlador(FormularioModelo modelo, FormularioVista vista) {

        this.modelo = modelo;
        this.vista = vista;

        vista.btnGuardar.addActionListener(e -> guardar());

        vista.menuCheck.addActionListener(e ->
                JOptionPane.showMessageDialog(vista,
                        "Menu checkbox: " + vista.menuCheck.isSelected()));
    }

    private void guardar() {

        modelo.setNombre(vista.txtNombre.getText());
        modelo.setCombo(vista.combo.getSelectedItem().toString());
        modelo.setAcepta(vista.chkAceptar.isSelected());

        if (vista.rbM.isSelected())
            modelo.setGenero("Masculino");
        else
            modelo.setGenero("Femenino");

        vista.modeloLista.addElement(modelo.getHistorial()
                .get(modelo.getHistorial().size()-1));

        JOptionPane.showMessageDialog(vista, modelo.resumen());
    }
}
