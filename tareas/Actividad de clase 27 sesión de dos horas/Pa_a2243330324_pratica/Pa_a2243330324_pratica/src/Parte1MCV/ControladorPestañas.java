package Parte1MCV;

public class ControladorPestañas {
    private VistaPestañas vista;

    public ControladorPestañas(VistaPestañas vista) {
        this.vista = vista;
      
    }

    public void mostrar() {
        this.vista.setVisible(true);
    }
}