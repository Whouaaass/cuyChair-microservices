package co.edu.unicauca.cuychair.gui;

import javax.swing.JFrame;

import co.edu.unicauca.cuychair.gui.views.EntryView;
import co.edu.unicauca.cuychair.gui.views.LoginView;

/**
 * Clase principal (Main) de la aplicación
 * Por aquí se inicia la aplicación
 */
public class CuyChairGUI {

    public static String LOOK_AND_FEEL = "Windows";

    public static void main(String[] args) {
        System.out.println("Starting application");
        initApp();
    }

    /**
     * Inicializa la aplicación
     */
    public static void initApp() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (LOOK_AND_FEEL.equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
                System.out.println(info.getName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LoginView());
        frame.pack();
        frame.setLocationRelativeTo(null);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> frame.setVisible(true));
    }

    /**
     * Termina la aplicación
     */
    public static void terminate() {
        System.out.println("Ending Application");
    }
}
