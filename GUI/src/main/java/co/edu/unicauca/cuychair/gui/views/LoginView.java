package co.edu.unicauca.cuychair.gui.views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import co.edu.unicauca.cuychair.gui.api.dtos.userAPI.LoginDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.userAPI.UserDTO;
import co.edu.unicauca.cuychair.gui.api.services.UserServices;
import co.edu.unicauca.cuychair.gui.context.AppContext;
import co.edu.unicauca.cuychair.gui.context.SessionContext;
import co.edu.unicauca.cuychair.gui.domain.User;

/**
 * Simple login view with username, password, and login button.
 */
public class LoginView extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;

    /**
     * Crea una nueva instancia de LoginView.
     */
    public LoginView() {
        initComponents();
    }

    /**
     * Inicializa los componentes de la vista
     */
    private void initComponents() {
        setLayout(new BorderLayout());

        // Create a panel with a border and a title
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Inicio de sesión"));
        panel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Username Label and Field
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Usuario:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        // Password Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        // Login Button
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.addActionListener(e -> authenticate());
        panel.add(loginButton, gbc);

        // Create Account Button
        gbc.gridy = 3;
        JButton createAccountButton = new JButton("Crear cuenta");
        createAccountButton.addActionListener(e -> navigateToSignup());
        panel.add(createAccountButton, gbc);

        add(panel, BorderLayout.CENTER);
    }

    private void authenticate() {
        UserServices userServices = AppContext.getInstance().getUserService();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        /*
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!("admin".equals(username) && "1234".equals(password))) {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
         */
        UserDTO result;

        result = userServices.login(new LoginDTO(username, password));

        if (result == null) {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save the user in the session context
        SessionContext.getInstance().setUser(new User(
                result.getId(),
                result.getName(),
                result.getLastName(),
                result.getEmail(),
                "none"
        ));

        // Navigate to the main view
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        currentFrame.dispose();
        JFrame mainFrame = new EntryView();
        mainFrame.setTitle("CuyChair");
        mainFrame.setVisible(true);
    }

    private void navigateToSignup() {
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        currentFrame.getContentPane().removeAll();
        currentFrame.add(new SignupView());
        currentFrame.setTitle("Registro de Usuario");
        currentFrame.revalidate();
        currentFrame.repaint();
        currentFrame.pack();

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inicio de Sesión");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new LoginView());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
