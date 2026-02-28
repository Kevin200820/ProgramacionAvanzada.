package Parte1MCV;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class VistaGeneral extends JFrame {
    public JButton Bsalir;
    public JTextField campoTexto;
    public JPasswordField campoPassword;
    public JTextArea areaTexto;
    public JFormattedTextField campoFormateado;
    public JSpinner spinner;
    public JSlider slider;
    public JComboBox<String> comboBox;

    public VistaGeneral() {
        setTitle("Practica MVC - Formulario Completo");
        setSize(442, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // JButton (con Mnemónico como en Practica02_b2)
        JLabel etiqueta1 = new JLabel("JButton:");
        etiqueta1.setBounds(10, 3, 170, 36);
        Bsalir = new JButton("Salir");
        Bsalir.setBounds(188, 3, 172, 36);
        Bsalir.setMnemonic(KeyEvent.VK_S); // Atajo Alt+S
        add(etiqueta1);
        add(Bsalir);

        // JTextField
        JLabel etiqueta2 = new JLabel("JTextField:");
        etiqueta2.setBounds(10, 50, 170, 36);
        campoTexto = new JTextField();
        campoTexto.setBounds(188, 50, 172, 36);
        add(etiqueta2);
        add(campoTexto);

        // JPasswordField
        JLabel etiqueta3 = new JLabel("JPasswordField:");
        etiqueta3.setBounds(10, 100, 170, 36);
        campoPassword = new JPasswordField();
        campoPassword.setBounds(188, 100, 172, 36);
        add(etiqueta3);
        add(campoPassword);

        // JTextArea con Scroll
        JLabel etiqueta4 = new JLabel("JTextArea:");
        etiqueta4.setBounds(10, 150, 170, 36);
        areaTexto = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBounds(188, 150, 172, 50);
        add(etiqueta4);
        add(scroll);

        // JSpinner y JSlider
        spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        spinner.setBounds(188, 220, 172, 36);
        add(spinner);

        slider = new JSlider(0, 100, 50);
        slider.setBounds(188, 270, 172, 45);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        add(slider);

        // JComboBox
        String[] opciones = {"Opción 1", "Opción 2", "Opción 3"};
        comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(188, 330, 172, 36);
        add(comboBox);
    }
}