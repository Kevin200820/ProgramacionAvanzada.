package Parte2MVC;

public class MainInsumos {
    public static void main(String[] args) {
        ModeloInsumos modelo = new ModeloInsumos();
       
        VistaInsumos vista = new VistaInsumos(modelo.getListaCategorias().CategoriasArreglo());
        new ControladorInsumos(vista, modelo);
        vista.setVisible(true);
    }
}