package Tareas;

import controlador.FormularioControlador;
import modelo.FormularioModelo;
import vista.FormularioVista;

public class Mainn {

    public static void main(String[] args) {

        FormularioModelo modelo = new FormularioModelo();
        FormularioVista vista = new FormularioVista();

        new FormularioControlador(modelo, vista);

        vista.setVisible(true);
    }
}
