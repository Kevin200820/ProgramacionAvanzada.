package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaTienda extends JInternalFrame {
    public JTextField txtId, txtNombre, txtPrecio;
    public JRadioButton rbDisponible, rbAgotado;
    public JButton btnCrear, btnConsultar, btnModificar, btnEliminar, btnLimpiar;
    public JTable tabla;
    public DefaultTableModel modeloTabla; 

    public VistaTienda() {
        super("Gestión de Inventario", true, true, true, true);
        setSize(850, 550);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0; c.gridy = 0; add(new JLabel("ID:"), c);
        c.gridx = 1; txtId = new JTextField(10); add(txtId, c);
        c.gridx = 0; c.gridy = 1; add(new JLabel("Nombre:"), c);
        c.gridx = 1; txtNombre = new JTextField(15); add(txtNombre, c);
        c.gridx = 0; c.gridy = 2; add(new JLabel("Precio:"), c);
        c.gridx = 1; txtPrecio = new JTextField(10); add(txtPrecio, c);

        rbDisponible = new JRadioButton("Disponible", true);
        rbAgotado = new JRadioButton("Agotado");
        ButtonGroup bg = new ButtonGroup(); bg.add(rbDisponible); bg.add(rbAgotado);
        JPanel pnl = new JPanel(); pnl.add(rbDisponible); pnl.add(rbAgotado);
        c.gridx = 0; c.gridy = 3; c.gridwidth = 2; add(pnl, c);

        JPanel pnlB = new JPanel();
        btnCrear = new JButton("Guardar");
        btnConsultar = new JButton("Buscar");
        btnModificar = new JButton("Editar");
        btnEliminar = new JButton("Borrar");
        btnLimpiar = new JButton("Nuevo");
        pnlB.add(btnCrear); pnlB.add(btnConsultar); pnlB.add(btnModificar);
        pnlB.add(btnEliminar); pnlB.add(btnLimpiar);
        c.gridy = 4; add(pnlB, c);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Precio", "Estado"}, 0);
        tabla = new JTable(modeloTabla);
        c.gridy = 5; c.weighty = 1.0; c.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(tabla), c);
    }
}