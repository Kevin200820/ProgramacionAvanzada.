package main;

import vista.EmpleadoForm;
import controlador.ControladorEmpleado;

public class Main {

    public static void main(String[] args) {
        EmpleadoForm f = new EmpleadoForm();
        new ControladorEmpleado(f);
        f.setVisible(true);
    }
}