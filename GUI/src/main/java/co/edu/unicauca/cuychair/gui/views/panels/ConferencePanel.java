package co.edu.unicauca.cuychair.gui.views.panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import co.edu.unicauca.cuychair.gui.api.services.ConferenceServices;
import co.edu.unicauca.cuychair.gui.context.AppContext;
import co.edu.unicauca.cuychair.gui.domain.Conference;
import co.edu.unicauca.cuychair.gui.views.components.ConferenceCard;
import co.edu.unicauca.cuychair.gui.views.components.GoBackWrapper;

/**
 * Panel para mostrar las conferencias disponibles
 *
 * @author Frdy
 */
public class ConferencePanel extends javax.swing.JPanel {

    private final List<JComponent> cards = new ArrayList<>();
    private JPanel mainPanel;

    private CardLayout layout;
    private JButton refreshButton;

    /**
     * Creates new form ConferencePanel
     */
    public ConferencePanel() {
        initComponents();
        fillData();
    }

    private void fillData() {

        ConferenceServices conferenceServices = AppContext.getInstance().getConferenceService();

        conferenceServices.getAllConferences().forEach(conference -> {
            cards.add(new ConferenceCard(
                    new Conference(conference.getTitle(), conference.getDescription(), conference.getDate(), "", "")
            ));
        });
        populateContentPanel(calculateColumns(scrollPanel.getWidth()));
    }

    private void initComponents() {
        mainPanel = new JPanel();
        scrollPanel = new JScrollPane();
        contentPanel = new javax.swing.JPanel();
        optionsPanel = new javax.swing.JPanel();
        createConferenceButton = new JButton("Crear Conferencia");
        refreshButton = new JButton("Actualizar");

        setLayout(new CardLayout());

        mainPanel.setLayout(new BorderLayout());

        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setViewportView(contentPanel);
        scrollPanel.setWheelScrollingEnabled(false);
        scrollPanel.addMouseWheelListener(evt -> scrollPanelMouseWheelMoved(evt));
        scrollPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                scrollPanelComponentResized(evt);
            }
        });

        contentPanel.setLayout(new GridBagLayout());
        scrollPanel.setViewportView(contentPanel);

        mainPanel.add(scrollPanel, BorderLayout.CENTER);

        optionsPanel.setPreferredSize(new java.awt.Dimension(150, 326));
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        optionsPanel.setBorder(BorderFactory.createTitledBorder("Acciones"));

        optionsPanel.add(createConferenceButton);
        optionsPanel.add(refreshButton);

        createConferenceButton.addActionListener(this::openCreateConferenceModal);
        refreshButton.addActionListener(e -> {
            cards.clear();
            fillData();
        });

        mainPanel.add(optionsPanel, BorderLayout.LINE_END);

        // Panel de crear conferencia
        // CreateConferencePanel createConferencePanel = new CreateConferencePanel();
        GoBackWrapper createConferencePanel = new GoBackWrapper(new CreateConferencePanel());
        createConferencePanel.addBackButtonActionListener(this::handleGoBack);

        add(createConferencePanel, "CreateConferencePanel");
        add(mainPanel, "mainPanel");

        layout = (CardLayout) getLayout();
        layout.show(this, "mainPanel");
    }

    /**
     * @param evt
     */
    private void scrollPanelComponentResized(java.awt.event.ComponentEvent evt) {
        evt.getSource();
        int columns = calculateColumns(scrollPanel.getWidth());
        populateContentPanel(columns);
    }

    private void scrollPanelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
        JScrollBar verticalBar = scrollPanel.getVerticalScrollBar();
        int scrollAmount = evt.getUnitsToScroll() * verticalBar.getUnitIncrement() * 20;
        verticalBar.setValue(verticalBar.getValue() + scrollAmount);
    }

    // Method to calculate the number of columns based on available width
    private int calculateColumns(int availableWidth) {
        return Math.max(1, availableWidth / (ConferenceCard.CARD_WIDTH)); // 10 is the gap between cards
    }

    private void populateContentPanel(int columns) {
        contentPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between cards
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        for (int i = 0; i < cards.size(); i++) {
            Component comp = cards.get(i);
            gbc.gridx = i % columns; // Column index
            gbc.gridy = i / columns; // Row index
            contentPanel.add(comp, gbc);
        }

        contentPanel.revalidate(); // Refresh the layout
        contentPanel.repaint();
    }

    private void openCreateConferenceModal(ActionEvent e) {
        layout.show(this, "CreateConferencePanel");
    }

    private void handleGoBack(ActionEvent e) {
        layout.show(this, "mainPanel");
    }

    private JScrollPane scrollPanel;
    private JPanel contentPanel;
    private JPanel optionsPanel;
    private JButton createConferenceButton;
}
