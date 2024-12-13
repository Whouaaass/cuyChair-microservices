package co.edu.unicauca.cuychair.gui.views.components;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import co.edu.unicauca.cuychair.gui.domain.Conference;
import co.edu.unicauca.cuychair.gui.utils.DateUtils;
import co.edu.unicauca.cuychair.gui.utils.StringUtils;

/**
 * Tarjeta visual para mostrar la información de una conferencia
 */
public class ConferenceCard extends JPanel {

    public static final int CARD_WIDTH = 220;

    private final Conference conference;

    public ConferenceCard(Conference conference) {
        this.conference = conference;
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        setBorder(BorderFactory.createEtchedBorder());

        // Wrapper panel for padding
        JPanel paddingWrapper = new JPanel(new BorderLayout(10, 10));
        paddingWrapper.setBorder(new EmptyBorder(10, 10, 10, 10)); // top, left, bottom, right

        add(paddingWrapper, BorderLayout.CENTER);

        // Title
        JLabel titleLabel = new JLabel(conference.getTitle());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        paddingWrapper.add(titleLabel, BorderLayout.NORTH);

        // Conference Info
        JPanel infoPanel = new JPanel(new GridLayout(5, 1));
        infoPanel.add(new JLabel(StringUtils.truncateWithEllipsis(conference.getDescription(), 30)));
        infoPanel.add(new JSeparator());
        infoPanel.add(new JLabel("Fecha: " + DateUtils.formatToPrettyDate(conference.getDate())));
        infoPanel.add(new JLabel("Ubicación: " + conference.getLocation()));
        infoPanel.add(new JLabel("Estado: " + conference.getStatus()));
        paddingWrapper.add(infoPanel, BorderLayout.CENTER);

        // Button to view details
        JButton viewButton = new JButton("Ver Más");
        viewButton.addActionListener(e -> showConferenceDetails(conference));
        paddingWrapper.add(viewButton, BorderLayout.SOUTH);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Conference conference = new Conference("IAS", "No se que es esto", new Date(), "more IAS", "more IAS");
        ConferenceCard card = new ConferenceCard(conference);
        JOptionPane.showMessageDialog(null, card, "Conference Card", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * 
     * @param conference
     */
    private void showConferenceDetails(Conference conference) {
        // Redirect logic placeholder
        JOptionPane.showMessageDialog(this, "Mostrando detalles para: " + conference.getTitle());
    }
}
