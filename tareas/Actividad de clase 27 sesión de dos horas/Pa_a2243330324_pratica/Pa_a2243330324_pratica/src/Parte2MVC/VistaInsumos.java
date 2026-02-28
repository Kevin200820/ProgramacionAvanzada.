package Parte2MVC;

import javax.swing.*;
import java.awt.BorderLayout;

public class VistaInsumos extends JFrame {
    public JComboBox<Object> comboCategoria;
    public JTextField tid, tinsumo;
    public JButton bagregar, beliminar, bsalir;
    public JTextArea areaProductos;

    public VistaInsumos(Object[] categorias) {
        super("Administración de Productos (MVC)");
        setBounds(100, 100, 390, 370);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(null);
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel l1 = new JLabel("ID:"); l1.setBounds(10, 9, 71, 20); panel.add(l1);
        tid = new JTextField(); tid.setBounds(91, 9, 147, 20); panel.add(tid);

        JLabel l2 = new JLabel("Insumo:"); l2.setBounds(10, 34, 71, 20); panel.add(l2);
        tinsumo = new JTextField(); tinsumo.setBounds(91, 35, 147, 20); panel.add(tinsumo);

        comboCategoria = new JComboBox<>(categorias);
        comboCategoria.setBounds(91, 66, 160, 20);
        panel.add(comboCategoria);

      
        bagregar = new JButton("Agregar"); bagregar.setBounds(20, 104, 111, 20); panel.add(bagregar);
        beliminar = new JButton("Eliminar"); beliminar.setBounds(153, 104, 111, 20); panel.add(beliminar);
        bsalir = new JButton("Salir"); bsalir.setBounds(274, 104, 79, 20); panel.add(bsalir);

        areaProductos = new JTextArea();
        areaProductos.setEditable(false);
        JScrollPane sp = new JScrollPane(areaProductos);
        sp.setBounds(10, 132, 357, 179);
        panel.add(sp);
    }
}