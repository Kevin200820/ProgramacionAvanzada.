package UDEMY;

import javax.swing.*;
import java.awt.*;

class LoginWindow extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoClave;
    private SistemaVentas sistema;

    public LoginWindow(SistemaVentas sistema) {

        this.sistema = sistema;

        setTitle("Sistema de Ventas - Acceso");
        setSize(430, 330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new BorderLayout());

        add(crearEncabezado(), BorderLayout.NORTH);
        add(crearFormulario(), BorderLayout.CENTER);
    }

    private JPanel crearEncabezado() {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(52, 152, 219));
        panel.setPreferredSize(new Dimension(400, 90));

        JLabel titulo = new JLabel("SISTEMA DE VENTAS");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setForeground(Color.WHITE);

        panel.add(titulo);
        return panel;
    }

    private JPanel crearFormulario() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Usuario:"), gbc);

        campoUsuario = new JTextField(18);
        gbc.gridx = 1;
        panel.add(campoUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Clave:"), gbc);

        campoClave = new JPasswordField(18);
        gbc.gridx = 1;
        panel.add(campoClave, gbc);

        JButton btnIngresar = new JButton("Ingresar");
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(btnIngresar, gbc);

        btnIngresar.addActionListener(e -> validar());
        campoClave.addActionListener(e -> validar());

        return panel;
    }

    private void validar() {

        String user = campoUsuario.getText();
        String pass = new String(campoClave.getPassword());

        Usuario u = sistema.login(user, pass);

        if (u != null) {
            dispose();
            new MainWindow(sistema).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Credenciales incorrectas",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}