package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VistaVenta extends JInternalFrame {
    public JTextField txtIdBusqueda, txtCantidad, txtTotal;
    public JButton btnAgregar, btnFinalizar, btnQuitar;
    public JTable tablaCarrito;
    public DefaultTableModel modeloTabla;

    public VistaVenta() {
        super("Punto de Venta", true, true, true, true);
        setSize(800, 500);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);

        c.gridx = 0; c.gridy = 0; add(new JLabel("ID:"), c);
        c.gridx = 1; txtIdBusqueda = new JTextField(10); add(txtIdBusqueda, c);
        c.gridx = 2; add(new JLabel("Cant:"), c);
        c.gridx = 3; txtCantidad = new JTextField(5); add(txtCantidad, c);
        btnAgregar = new JButton("Añadir");
        c.gridx = 4; add(btnAgregar, c);

        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Cant.", "Precio", "Subtotal"}, 0);
        tablaCarrito = new JTable(modeloTabla);
        c.gridx = 0; c.gridy = 1; c.gridwidth = 5; c.weighty = 1.0; c.fill = GridBagConstraints.BOTH;
        add(new JScrollPane(tablaCarrito), c);

        JPanel pnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        txtTotal = new JTextField(10); txtTotal.setEditable(false);
        btnQuitar = new JButton("Quitar");
        btnFinalizar = new JButton("Pagar");
        pnl.add(new JLabel("Total: $")); pnl.add(txtTotal); pnl.add(btnQuitar); pnl.add(btnFinalizar);
        c.gridy = 2; c.weighty = 0; c.fill = GridBagConstraints.HORIZONTAL;
        add(pnl, c);
    }
}