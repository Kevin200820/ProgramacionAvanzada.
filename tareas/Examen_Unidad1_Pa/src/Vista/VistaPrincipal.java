package Vista;

import javax.swing.*;

public class VistaPrincipal extends JFrame {
    
    public JDesktopPane desktop;
    public JMenuItem menuInventario;
    public JMenuItem menuVenta;
    public JMenuItem menuSalir;

    public VistaPrincipal() {
        setTitle("Sistema de Gestión"); 
        setSize(1100, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktop = new JDesktopPane();
        add(desktop);

        JMenuBar barra = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");

        
        menuInventario = new JMenuItem("Productos");
        menuVenta = new JMenuItem("Ventas");
        menuSalir = new JMenuItem("Salir");

        menuArchivo.add(menuInventario);
        menuArchivo.add(menuVenta);
        menuArchivo.addSeparator();
        menuArchivo.add(menuSalir);
        
        barra.add(menuArchivo);
        setJMenuBar(barra);
    }
}