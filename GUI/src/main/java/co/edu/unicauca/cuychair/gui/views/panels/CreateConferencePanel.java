package co.edu.unicauca.cuychair.gui.views.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import co.edu.unicauca.cuychair.gui.api.dtos.conferenceAPI.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.api.services.ConferenceServices;
import co.edu.unicauca.cuychair.gui.api.services.UserServices;
import co.edu.unicauca.cuychair.gui.context.AppContext;
import co.edu.unicauca.cuychair.gui.context.SessionContext;
import co.edu.unicauca.cuychair.gui.utils.DateLabelFormatter;
import co.edu.unicauca.cuychair.gui.views.modals.InputModal;

public class CreateConferencePanel extends JPanel {

    private static final String[] DUMMY_REVIEWERS = {"Revisor 1"};
    private static final String[] DUMMY_AUTHORS = {"Autor 1"};

    private static final int BORDER_PADDING = 20;
    private static final int FIELD_WIDTH = 200;
    private static final int TEXT_AREA_ROWS = 5;
    private static final int LIST_HEIGHT = 70;
    private static final int GRID_VGAP = 10;
    private static final int GRID_HGAP = 15;

    // Declare components
    private JTextField txtTitle;
    private JTextField txtSubject;
    private JTextField txtCity;
    private JTextField txtDate;
    private JTextArea txtDescription;
    private JDatePickerImpl datePicker;
    private JList<String> listReviewers;
    private DefaultListModel<String> listModelReviewers;
    private JList<String> listAuthors;
    private DefaultListModel<String> listModelAuthors;
    private JButton btnSubmit;
    private JPanel mainPanel;

    public CreateConferencePanel() {
        initComponents();
    }

    private void initComponents() {
        // Initialize components with improved dimensions
        mainPanel = new JPanel();
        txtTitle = new JTextField();
        txtSubject = new JTextField();
        txtCity = new JTextField();
        txtDate = new JTextField();
        txtDescription = new JTextArea(TEXT_AREA_ROWS, 20);
        listReviewers = new JList<>(listModelReviewers = new DefaultListModel<>());
        listAuthors = new JList<>(listModelAuthors = new DefaultListModel<>());
        btnSubmit = new JButton("Crear Conferencia");
        JPanel inputPanel = new JPanel(new GridBagLayout());

        // Set preferred sizes
        Dimension fieldSize = new Dimension(FIELD_WIDTH, txtTitle.getPreferredSize().height);
        txtTitle.setPreferredSize(fieldSize);
        txtSubject.setPreferredSize(fieldSize);
        txtCity.setPreferredSize(fieldSize);
        txtDate.setPreferredSize(fieldSize);

        // Configure components
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        btnSubmit.setFont(new Font(btnSubmit.getFont().getName(), Font.BOLD, 14));

        // Layout setup
        mainPanel.setLayout(new BorderLayout(GRID_HGAP, GRID_VGAP));
        mainPanel.setBorder(new EmptyBorder(BORDER_PADDING, BORDER_PADDING, BORDER_PADDING, BORDER_PADDING));

        // Create main input panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Add components with GridBagLayout
        addFormField(inputPanel, "Titulo:", txtTitle, gbc, 0);
        addFormField(inputPanel, "Tema:", txtSubject, gbc, 1);
        addFormField(inputPanel, "Ciudad:", txtCity, gbc, 2);
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model, new Properties() {
            {
                put("text.today", "Hoy");
                put("text.month", "Mes");
                put("text.year", "Año");
            }
        });
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        addFormField(inputPanel, "Fecha:", datePicker, gbc, 3);

        // Description area
        gbc.gridy = 4;
        gbc.gridx = 0;
        inputPanel.add(new JLabel("Descripcion:"), gbc);
        gbc.gridx = 1;
        gbc.weighty = 1.0;
        inputPanel.add(new JScrollPane(txtDescription), gbc);

        // Lists panel
        JPanel listsPanel = new JPanel(new GridLayout(2, 1, GRID_HGAP, GRID_VGAP));

        // Configure lists with fixed height
        JScrollPane reviewersScroll = new JScrollPane(listReviewers);
        JScrollPane authorsScroll = new JScrollPane(listAuthors);
        reviewersScroll.setPreferredSize(new Dimension(FIELD_WIDTH, LIST_HEIGHT));
        authorsScroll.setPreferredSize(new Dimension(FIELD_WIDTH, LIST_HEIGHT));

        // Wrap JScrollPanes in panels
        JPanel reviewersPanel = new JPanel(new BorderLayout());
        reviewersPanel.setBorder(BorderFactory.createTitledBorder("Revisores"));
        reviewersPanel.add(reviewersScroll, BorderLayout.CENTER);
        JButton btnAddReviewer = new JButton("Agregar");
        JButton btnRemoveReviewer = new JButton("Remover");
        JPanel reviewersButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddReviewer.addActionListener(
                l -> addPersonThroughModal("Ingrese el correo del revisor:", listModelReviewers)
        );
        btnRemoveReviewer.addActionListener(l -> removeSelectedIndex(listReviewers, listModelReviewers));
        reviewersButtonsPanel.add(btnAddReviewer);
        reviewersButtonsPanel.add(btnRemoveReviewer);
        reviewersPanel.add(reviewersButtonsPanel, BorderLayout.SOUTH);

        JPanel authorsPanel = new JPanel(new BorderLayout());
        authorsPanel.setBorder(BorderFactory.createTitledBorder("Autores"));
        authorsPanel.add(authorsScroll, BorderLayout.CENTER);
        JButton btnAddAuthor = new JButton("Add");
        JButton btnRemoveAuthor = new JButton("Remove");
        JPanel authorsButtonsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAddAuthor.addActionListener(l
                -> addPersonThroughModal("Ingrese el correo del autor:", listModelAuthors)
        );
        btnRemoveAuthor.addActionListener(l -> removeSelectedIndex(listAuthors, listModelAuthors));
        authorsButtonsPanel.add(btnAddAuthor);
        authorsButtonsPanel.add(btnRemoveAuthor);
        authorsPanel.add(authorsButtonsPanel, BorderLayout.SOUTH);

        listsPanel.add(reviewersPanel);
        listsPanel.add(authorsPanel);
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnSubmit.addActionListener(this::handleCreateConference);
        buttonPanel.add(btnSubmit);

        // Add all panels to main panel
        mainPanel.add(inputPanel, BorderLayout.WEST);
        mainPanel.add(listsPanel, BorderLayout.EAST);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void addFormField(JPanel panel, String label, JComponent field, GridBagConstraints gbc, int row) {
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.weightx = 0.0;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panel.add(field, gbc);
    }

    private void addPersonThroughModal(String message, DefaultListModel<String> list) {
        Window ancestor = SwingUtilities.getWindowAncestor(this);
        while (ancestor != null && !(ancestor instanceof JFrame)) {
            ancestor = SwingUtilities.getWindowAncestor(ancestor);
        }
        if (ancestor == null) {
            return;
        }
        InputModal modal = new InputModal((JFrame) ancestor,
                message,
                (String input) -> {
                    list.addElement(input);
                });
        modal.setVisible(true);
    }

    private void removeSelectedIndex(JList<String> list, DefaultListModel<String> listModel) {
        int selectedIndex = list.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        }
    }

    private void clearFields() {
        txtTitle.setText("");
        txtSubject.setText("");
        txtCity.setText("");
        txtDate.setText("");
        txtDescription.setText("");
        listModelReviewers.clear();
        listModelAuthors.clear();
    }

    private void handleCreateConference(ActionEvent evt) {
        ConferenceServices conferenceServices = AppContext.getInstance().getConferenceService();
        UserServices userServices = AppContext.getInstance().getUserService();
        String title = txtTitle.getText();
        String subject = txtSubject.getText();
        String city = txtCity.getText();
        Date date = (Date) datePicker.getModel().getValue();
        String description = txtDescription.getText();

        System.out.println("Creating conference...");
        System.out.println("Title: " + title);
        System.out.println("Subject: " + subject);
        System.out.println("City: " + city);
        System.out.println("Date: " + date);
        System.out.println("Description: " + description);
        System.out.println("Reviewers: " + listModelReviewers);
        System.out.println("Authors: " + listModelAuthors);

        if (title.isEmpty() || subject.isEmpty() || city.isEmpty() || date == null || description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son requeridos!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ConferenceDTO response = conferenceServices.addConference(
                city,
                title,
                subject,
                date,
                description,
                SessionContext.getInstance().getUserId()
        );
        if (response == null) {
            JOptionPane.showMessageDialog(this, "Hubo un error al crear la conferencia", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Conferencia creada exitosamente!", "Exito", JOptionPane.INFORMATION_MESSAGE);
        
        
        for (int i = 0; i < listModelAuthors.size(); i++) {
            String email = listModelAuthors.get(i);
            try {
                response = conferenceServices.addAuthor(response.getId(), userServices.getUserByEmail(email).getId());    
            } catch (Exception e) {
                System.out.printf("Error al agregar author %s\n", e.getMessage());
            }
            
        }
        for (int i = 0; i < listModelReviewers.size(); i++) {
            String email = listModelReviewers.get(i);
            try {
            response = conferenceServices.addReviewer(response.getId(), userServices.getUserByEmail(email).getId());
            } catch (Exception e) {
                System.out.printf("Error al agregar revisor %s\n", e.getMessage());
            }
        }
        clearFields();
        System.out.println(response);
    }

    public static void main(String[] args) {
        // Run the application
        JFrame frame = new JFrame("Crear Conferencia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(new CreateConferencePanel());
        frame.pack();
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
}
