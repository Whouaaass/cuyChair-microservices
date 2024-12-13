package co.edu.unicauca.cuychair.gui.views.panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.edu.unicauca.cuychair.gui.api.dtos.conferenceAPI.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperAPI.PaperDTO;
import co.edu.unicauca.cuychair.gui.api.services.ConferenceServices;
import co.edu.unicauca.cuychair.gui.api.services.PaperReviewServices;
import co.edu.unicauca.cuychair.gui.api.services.PaperServices;
import co.edu.unicauca.cuychair.gui.context.AppContext;
import co.edu.unicauca.cuychair.gui.context.SessionContext;

public class CreatePaperPanel extends JPanel {
    private JTextField txtTitle;
    private JTextField txtSubtitle;
    private JTextArea txtAbstract;
    private JComboBox<ConferenceDTO> cmbConference;
    private JButton btnSubmit; // Add this field
    
    public CreatePaperPanel() {
        ConferenceServices conferenceServices = AppContext.getInstance().getConferenceService();
        initComponents();
        conferenceServices.getAllConferences().forEach(cmbConference::addItem);
    }
    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Title:"), gbc);
        
        txtTitle = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(txtTitle, gbc);
        
        // Subtitle
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Subtitle:"), gbc);
        
        txtSubtitle = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(txtSubtitle, gbc);
        
        // Abstract
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Abstract:"), gbc);
        
        txtAbstract = new JTextArea(5, 30);
        txtAbstract.setLineWrap(true);
        txtAbstract.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtAbstract);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(scrollPane, gbc);
        
        // Conference
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Conference:"), gbc);
        
        cmbConference = new JComboBox<>();
        // Add conference options here
        gbc.gridx = 1;
        gbc.gridy = 3;
        add(cmbConference, gbc);
        
        // Add Submit Button
        btnSubmit = new JButton("Submit Paper");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(btnSubmit, gbc);
        
        // Add action listener
        btnSubmit.addActionListener(e -> handleCreatePanel());
    }


    private void handleCreatePanel() {
        PaperServices paperServices = AppContext.getInstance().getPaperService();
        PaperReviewServices paperReviewServices = AppContext.getInstance().getPaperReviewService();
        
        // Create a new paper
        PaperDTO paper = new PaperDTO(
            0,
            getPaperTitle(),
            getPaperAbstract(),
            getPaperSubtitle(),
            SessionContext.getInstance().getUserId(), // Author ID
            getSelectedConference().getId() // Conference ID
        );
        
        // Add the paper to the database
        PaperDTO paperDTO = paperServices.addPaper(paper);
        if (paperDTO == null) {
            // Show error message
            JOptionPane.showMessageDialog(this, "Error creating paper", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Show success message
        JOptionPane.showMessageDialog(this, "Paper created successfully");
    }
    
    // Getters for form fields
    public String getPaperTitle() {
        return txtTitle.getText();
    }
    
    public String getPaperSubtitle() {
        return txtSubtitle.getText();
    }
    
    public String getPaperAbstract() {
        return txtAbstract.getText();
    }
    
    public ConferenceDTO getSelectedConference() {
        return (ConferenceDTO) cmbConference.getSelectedItem();
    }
}

