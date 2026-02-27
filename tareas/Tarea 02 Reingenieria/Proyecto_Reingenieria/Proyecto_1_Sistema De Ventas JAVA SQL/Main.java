package UDEMY;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {

        aplicarLookAndFeel();

        SwingUtilities.invokeLater(() -> {
            SistemaVentas sistema = new SistemaVentas();
            new LoginWindow(sistema).setVisible(true);
        });
    }

    private static void aplicarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}