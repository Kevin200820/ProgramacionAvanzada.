package vista;

import javax.swing.*;

public class Login extends JFrame {

    public JTextField txtUser = new JTextField();
    public JPasswordField txtPass = new JPasswordField();
    public JButton btnLogin = new JButton("Ingresar");
    public JProgressBar barra = new JProgressBar();

    public Login() {

        setTitle("Login");
        setSize(300,200);
        setLayout(null);
        setLocationRelativeTo(null);

        add(txtUser).setBounds(50,20,200,25);
        add(txtPass).setBounds(50,50,200,25);
        add(btnLogin).setBounds(90,80,120,30);
        add(barra).setBounds(20,130,250,20);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}