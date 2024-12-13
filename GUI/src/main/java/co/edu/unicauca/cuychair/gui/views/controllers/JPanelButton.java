package co.edu.unicauca.cuychair.gui.views.controllers;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

import javax.swing.JPanel;

public class JPanelButton extends JPanel {
    private final JPanel decoratedPanel;

    public JPanelButton(JPanel panel) {        
        this.decoratedPanel = panel;
        this.setLayout(new java.awt.BorderLayout());
        this.add(decoratedPanel, java.awt.BorderLayout.CENTER);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    public final void setListeners(Consumer<MouseEvent> onClick, Consumer<MouseEvent> onHover) {        
        addMouseListener(getMouseAdapter(onClick, onHover));
    }

    private MouseListener getMouseAdapter(Consumer<MouseEvent> onClick, Consumer<MouseEvent> onHover) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (onClick != null) onClick.accept(e);
            }
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                if (onHover != null) onHover.accept(e);
                setOpaque(true);
                setBackground(java.awt.Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                setOpaque(false);
                setBackground(null);
            }
        };
    } 

    // Forward some common JPanel methods to the decorated panel
    @Override
    public void setBackground(java.awt.Color bg) {
        super.setBackground(bg);
        if (decoratedPanel != null) {
            decoratedPanel.setBackground(bg);
        }
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(isOpaque);
        if (decoratedPanel != null) {
            decoratedPanel.setOpaque(isOpaque);
        }
    }    
}