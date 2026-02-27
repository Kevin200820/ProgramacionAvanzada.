package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class EmpleadoForm extends JFrame {

    public JTextField txtNombre = new JTextField();
    public JComboBox<String> cbCargo = new JComboBox<>(new String[]{"Admin","User"});
    public JRadioButton rbM = new JRadioButton("M");
    public JRadioButton rbF = new JRadioButton("F");
    public JButton btnGuardar = new JButton("Guardar");
    public JButton btnEliminar = new JButton("Eliminar");
    public JTable tabla = new JTable(new DefaultTableModel(
            new Object[]{"ID","Nombre","Genero","Cargo"},0));

    public EmpleadoForm() {

        setTitle("Empleados");
        setSize(600,400);
        setLayout(null);
        setLocationRelativeTo(null);

        add(txtNombre).setBounds(20,20,200,25);
        add(cbCargo).setBounds(20,50,200,25);
        add(rbM).setBounds(20,80,50,25);
        add(rbF).setBounds(80,80,50,25);
        add(btnGuardar).setBounds(20,120,100,30);
        add(btnEliminar).setBounds(130,120,100,30);
        add(new JScrollPane(tabla)).setBounds(250,20,320,300);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbM);
        bg.add(rbF);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}