package Parte1MCV;

public class Main {
    public static void main(String[] args) {
      
        VistaGeneral laVista = new VistaGeneral();
        ModeloDatos elModelo = new ModeloDatos();
        
        
        new ControladorGeneral(laVista, elModelo);
        
      
        laVista.setVisible(true);
    }
}