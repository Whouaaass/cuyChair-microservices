package examples;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

/**
 * Ejemplo de como crear un panel con scroll que ajusta dinámicamente el número de columnas.
 */
public class GridWrapScrollPanelExample extends JFrame {
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private final int cardWidth = 100; // Width of each card
    private final int cardHeight = 100; // Height of each card
    private final int cardCount = 20; // Total number of cards

    public GridWrapScrollPanelExample() {
        setTitle("Dynamic Grid Wrap Scroll Panel Example");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize content panel with GridBagLayout
        contentPanel = new JPanel(new GridBagLayout());
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);

        // Populate the initial layout
        populateContentPanel(calculateColumns(scrollPane.getWidth()));

        // Add a listener to handle resizing and dynamically adjust columns
        scrollPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int columns = calculateColumns(scrollPane.getWidth());
                populateContentPanel(columns);
            }
        });
    }

    
    /** 
     * @param availableWidth
     * @return int
     */
    // Method to calculate the number of columns based on available width
    private int calculateColumns(int availableWidth) {
        return Math.max(1, availableWidth / (cardWidth + 10)); // 10 is the gap between cards
    }

    // Method to populate the content panel with a grid layout
    private void populateContentPanel(int columns) {
        contentPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between cards
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        for (int i = 0; i < cardCount; i++) {
            JPanel card = createCard(i + 1);
            gbc.gridx = i % columns; // Column index
            gbc.gridy = i / columns; // Row index
            contentPanel.add(card, gbc);
        }

        contentPanel.revalidate(); // Refresh the layout
        contentPanel.repaint();
    }

    // Helper method to create a sample card component
    private JPanel createCard(int index) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(cardWidth, cardHeight));
        card.setBackground(new Color(100 + index * 5, 150, 255 - index * 5));
        card.add(new JLabel("Card " + index));
        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GridWrapScrollPanelExample example = new GridWrapScrollPanelExample();
            example.setVisible(true);
        });
    }
}
