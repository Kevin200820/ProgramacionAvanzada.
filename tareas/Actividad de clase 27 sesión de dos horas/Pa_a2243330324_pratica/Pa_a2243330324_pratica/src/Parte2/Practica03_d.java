package Parte2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Practica03_d extends JFrame implements ActionListener {

    ListaInsumos listainsumo;
    ListaCategorias listacategorias;
    
    private JComboBox<Categoria> ComboCategoria;
    private JTextField Tid, Tinsumo;
    private JButton Bagregar, Beliminar, Bsalir;
    private JTextArea areaProductos;
    private JPanel panelFormulario;

    public Practica03_d() {
        super("Practica 03_d - Gestión de Insumos");
        
        this.inicializarcategorias();
        this.listainsumo = new ListaInsumos();

        setBounds(100, 100, 390, 370);
        panelFormulario = new JPanel();
        panelFormulario.setLayout(null);
        getContentPane().add(panelFormulario, BorderLayout.CENTER);

        
        Tid = new JTextField(); Tid.setBounds(91, 9, 147, 20); panelFormulario.add(Tid);
        Tinsumo = new JTextField(); Tinsumo.setBounds(91, 35, 147, 20); panelFormulario.add(Tinsumo);

        
        ComboCategoria = new JComboBox<>();
        ComboCategoria = listacategorias.agregarCategoriasAComboBox(ComboCategoria);
        ComboCategoria.setBounds(91, 66, 160, 20);
        ComboCategoria.setEnabled(true); 
        panelFormulario.add(ComboCategoria);

        Bagregar = new JButton("Agregar"); Bagregar.setBounds(20, 104, 111, 20);
        Bagregar.addActionListener(this); panelFormulario.add(Bagregar);

        Beliminar = new JButton("Eliminar"); Beliminar.setBounds(153, 104, 111, 20);
        Beliminar.addActionListener(this); panelFormulario.add(Beliminar);

        Bsalir = new JButton("Salir"); Bsalir.setBounds(274, 104, 79, 20);
        Bsalir.addActionListener(this); panelFormulario.add(Bsalir);

        areaProductos = new JTextArea();
        JScrollPane sp = new JScrollPane(areaProductos);
        sp.setBounds(10, 132, 357, 179);
        panelFormulario.add(sp);

        this.Volveralinicio();
    }

    public void Altas() {
        if (this.Bagregar.getText().equals("Agregar")) {
            this.Bagregar.setText("Salvar");
            this.Bsalir.setText("Cancelar");
            this.Beliminar.setEnabled(false);
            this.Tid.setEditable(true);
            this.Tinsumo.setEditable(true);
            
            
            this.ComboCategoria.setSelectedIndex(0); 
            this.Tid.requestFocus();
        } else {
          
            String id = Tid.getText();
            String nombre = Tinsumo.getText();
            Categoria cat = (Categoria) ComboCategoria.getSelectedItem();
            Insumo nodo = new Insumo(id, nombre, cat.getIdcategoria());
            
            if (listainsumo.agregarInsumo(nodo)) {
                areaProductos.setText(listainsumo.toString());
                Volveralinicio();
            } else {
                JOptionPane.showMessageDialog(this, "Error: ID duplicado");
            }
        }
    }

    public void Volveralinicio() {
        this.Bagregar.setText("Agregar");
        this.Bsalir.setText("Salir");
        this.Beliminar.setEnabled(true);
        this.Tid.setEditable(false);
        this.Tinsumo.setEditable(false);
        this.Tid.setText("");
        this.Tinsumo.setText("");
    }

    private void inicializarcategorias() {
        this.listacategorias = new ListaCategorias();
        this.listacategorias.agregarCategoria(new Categoria("01", "Materiales"));
        this.listacategorias.agregarCategoria(new Categoria("02", "Mano de Obra"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Bagregar) Altas();
        if (e.getSource() == Bsalir) {
            if (Bsalir.getText().equals("Salir")) dispose();
            else Volveralinicio();
        }
    }

    public static void main(String[] args) {
        new Practica03_d().setVisible(true);
    }
}