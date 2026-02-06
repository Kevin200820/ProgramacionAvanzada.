package vista;

import javax.swing.*;
import java.awt.*;

public class FormularioVista extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtNombre;
    public JComboBox<String> combo;
    public JCheckBox chkAceptar;

    public JRadioButton rbM;
    public JRadioButton rbF;

    public JList<String> lista;
    public DefaultListModel<String> modeloLista;

    public JButton btnGuardar;

    public JCheckBoxMenuItem menuCheck;

    public FormularioVista() {

        setTitle("Proyecto 11-20");
        setSize(520,420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(7,2));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Combo:"));
        combo = new JComboBox<>(new String[]{"A","B","C"});
        add(combo);

        chkAceptar = new JCheckBox("Aceptar términos");
        add(chkAceptar);
        add(new JLabel(""));

        rbM = new JRadioButton("Masculino");
        rbF = new JRadioButton("Femenino");

        ButtonGroup g = new ButtonGroup();
        g.add(rbM);
        g.add(rbF);

        add(rbM);
        add(rbF);

        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        add(new JScrollPane(lista));

        btnGuardar = new JButton("Guardar");
        add(btnGuardar);

        // MENU
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        menuCheck = new JCheckBoxMenuItem("Activar opción");
        menu.add(menuCheck);

        barra.add(menu);
        setJMenuBar(barra);
    }
}
