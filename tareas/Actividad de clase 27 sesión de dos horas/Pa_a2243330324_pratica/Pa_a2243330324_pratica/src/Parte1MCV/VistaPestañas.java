package Parte1MCV;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class VistaPestañas extends JFrame {
    public JTabbedPane tabbedPane;

    public VistaPestañas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setTitle("Frame Practica01_01_b - Modo MVC");

        tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
       
        tabbedPane.addTab("Pestaña 1", new JPanel());

       
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        tabbedPane.addTab("Pestaña 2", scrollPane);

        setContentPane(tabbedPane);
    }
}