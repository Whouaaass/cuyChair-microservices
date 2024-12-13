package co.edu.unicauca.cuychair.gui.views.modals;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Modal para ingresar datos
 */
public class InputModal extends JDialog {

    private JButton submitBtn;
    private JTextField inputField;
    private JLabel messageLabel;
    private Consumer<String> onSubmit;

    public InputModal(JFrame parent, String message, Consumer<String> onSubmit) {
        super(parent, "Ingrese datos", true);
        this.onSubmit = onSubmit;        
        initComponents();
        messageLabel.setText(message);
        setLocationRelativeTo(parent);
    }
    
    public final void initComponents() {
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        messageLabel = new JLabel();
        
        inputField = new JTextField(20);
        inputField.setPreferredSize(new Dimension(200, 30));
        
        submitBtn = new JButton("Enviar");
        submitBtn.setPreferredSize(new Dimension(100, 30));

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        contentPanel.add(messageLabel, gbc);
        contentPanel.add(inputField, gbc);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitBtn);
        contentPanel.add(buttonPanel, gbc);

        add(contentPanel, BorderLayout.CENTER);

        submitBtn.addActionListener(e -> submitAction());
        
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitAction();
                }
            }
        });

        pack();
        setMinimumSize(new Dimension(300, 200));
    }

    private void submitAction() {
        this.onSubmit.accept(inputField.getText());
        dispose();
    }
}

