package controlador;

import modelo.Persona;
import vista.VistaBasica;

public class ControladorBasico {

    private Persona modelo;
    private VistaBasica vista;

    public ControladorBasico(Persona modelo, VistaBasica vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.btnSaludar.addActionListener(e -> saludar());
    }

    private void saludar() {

        modelo.setNombre(vista.txtNombre.getText());

        vista.lblResultado.setText("Hola " + modelo.getNombre());
    }
}
