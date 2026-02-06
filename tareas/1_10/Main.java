package Tareas;

import controlador.ControladorBasico;
import modelo.Persona;
import vista.VistaBasica;

public class Main {

    public static void main(String[] args) {

        Persona modelo = new Persona();
        VistaBasica vista = new VistaBasica();

        new ControladorBasico(modelo, vista);

        vista.setVisible(true);
    }
}
