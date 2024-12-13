package co.edu.unicauca.cuychair.gui.views.components;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInfo extends JPanel {

    public UserInfo(String mail, String username) {
        initComponents();
        mailLabel.setText(mail);
        usernameLabel.setText(username);
    }

    private void initComponents() {
        userIconLabel = new javax.swing.JLabel();
        userInfoLabel = new javax.swing.JPanel();
        mailLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();

        userInfoLabel.setLayout(new javax.swing.BoxLayout(userInfoLabel, javax.swing.BoxLayout.Y_AXIS));
        userInfoLabel.setOpaque(false);

        mailLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        mailLabel.setText("user@mail.com");
        userInfoLabel.add(mailLabel);

        usernameLabel.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        usernameLabel.setText("Nombre de Usuario");
        userInfoLabel.add(usernameLabel);

        userIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userIcon.png"))); // NOI18N

        add(userIconLabel);
        add(userInfoLabel);
    }

    private JLabel userIconLabel;
    private JPanel userInfoLabel;
    private JLabel mailLabel;
    private JLabel usernameLabel;
    
}
