package co.edu.unicauca.cuychair.gui.views.components;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GoBackWrapper extends JPanel {

    

    public GoBackWrapper(JPanel innerPanel) {
        initComponents();
        add(innerPanel, BorderLayout.CENTER);
    }

    private void initComponents() {
        backButton = new JButton("Volver");
        JPanel wrapperActionsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        setLayout(new BorderLayout());

        wrapperActionsPanel.add(backButton);

        add(wrapperActionsPanel, BorderLayout.SOUTH);
    }

    public void addBackButtonActionListener(ActionListener action) {
        backButton.addActionListener(action);
    }


    private JButton backButton;
}
