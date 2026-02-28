package Parte1MCV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControladorGeneral implements ActionListener {
    private VistaGeneral vista;
    private ModeloDatos modelo;

    public ControladorGeneral(VistaGeneral vista, ModeloDatos modelo) {
        this.vista = vista;
        this.modelo = modelo;
        
       
        this.vista.Bsalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.Bsalir) {
          
            modelo.setTexto(vista.campoTexto.getText());
            modelo.setPassword(new String(vista.campoPassword.getPassword()));
            modelo.setValorSpinner((int)vista.spinner.getValue());
            
           
            String mensaje = "Datos guardados en Modelo:\n" +
                             "Usuario: " + modelo.getTexto() + "\n" +
                             "Valor Spinner: " + modelo.getValorSpinner();
                             
            JOptionPane.showMessageDialog(vista, mensaje + "\n¡Hasta Luego!");
            vista.dispose();
        }
    }
}