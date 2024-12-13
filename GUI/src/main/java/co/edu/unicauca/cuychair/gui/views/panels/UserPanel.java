package co.edu.unicauca.cuychair.gui.views.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UserPanel extends JPanel {
    private JLabel lblName, lblLastname, lblEmail, lblDescription, lblPhone;
    private JTextField txtName, txtLastname, txtEmail, txtPhone;
    private JTextArea txtDescription;
    private JScrollPane scrollDescription;
    private JButton btnEdit;  // Add this field

    public UserPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Initialize components
        lblName = new JLabel("Nombre:");
        lblLastname = new JLabel("Apellido:");
        lblEmail = new JLabel("Correo:");
        lblDescription = new JLabel("Descripción:");
        lblPhone = new JLabel("Teléfono");
        
        txtName = new JTextField(20);
        txtLastname = new JTextField(20);
        txtEmail = new JTextField(20);
        txtPhone = new JTextField(20);
        txtDescription = new JTextArea(4, 20);
        scrollDescription = new JScrollPane(txtDescription);
        
        // Initialize edit button
        btnEdit = new JButton("Edit");
        
        // Add components to panel
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Name
        gbc.gridx = 0; gbc.gridy = 0;
        add(lblName, gbc);
        gbc.gridx = 1;
        add(txtName, gbc);
        
        // Lastname
        gbc.gridx = 0; gbc.gridy = 1;
        add(lblLastname, gbc);
        gbc.gridx = 1;
        add(txtLastname, gbc);
        
        // Email
        gbc.gridx = 0; gbc.gridy = 2;
        add(lblEmail, gbc);
        gbc.gridx = 1;
        add(txtEmail, gbc);
        
        // Phone
        gbc.gridx = 0; gbc.gridy = 3;
        add(lblPhone, gbc);
        gbc.gridx = 1;
        add(txtPhone, gbc);
        
        // Description
        gbc.gridx = 0; gbc.gridy = 4;
        add(lblDescription, gbc);
        gbc.gridx = 1;
        add(scrollDescription, gbc);
        
        // Add edit button at the bottom
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnEdit, gbc);
    }
}
