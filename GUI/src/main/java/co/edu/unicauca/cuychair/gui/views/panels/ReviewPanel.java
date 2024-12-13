package co.edu.unicauca.cuychair.gui.views.panels;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import co.edu.unicauca.cuychair.gui.api.dtos.conferenceAPI.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.PaperReviewItemDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.ResultChangeStateDTO;
import co.edu.unicauca.cuychair.gui.api.services.ConferenceServices;
import co.edu.unicauca.cuychair.gui.api.services.PaperReviewServices;
import co.edu.unicauca.cuychair.gui.context.AppContext;
import co.edu.unicauca.cuychair.gui.context.SessionContext;
import co.edu.unicauca.cuychair.gui.views.controllers.JCustomTextArea;

/**
 * Panel para enviar revisiones de artículos
 *
 * @author Frdy
 */
public class ReviewPanel extends JPanel {

    private final int COMMENT_LIMIT = 1000; // Límite de caracteres para comentarios

    private JList<PaperReviewItemDTO> articleList; // Lista de artículos
    private JTextArea commentsArea; // Área para escribir comentarios
    private JComboBox<String> ratingCombo; // ComboBox para calificación
    private JButton submitButton; // Botón para enviar la revisión

    public ReviewPanel() {
        initComponents();
        loadToReview();
    }

    /**
     * Inicializa los componentes del panel
     */
    private void loadToReview() {
        PaperReviewServices paperReviewServices = AppContext.getInstance().getPaperReviewService();
        ConferenceServices conferenceServices = AppContext.getInstance().getConferenceService();

        // Obtener los artículos pendientes de revisión
        List<ConferenceDTO> relatedConferences = conferenceServices.findAllByReviewer(
                SessionContext.getInstance().getUserId()
        );
        if (relatedConferences == null) {
            return;
        }
        List<PaperReviewItemDTO> pendingReviews = new ArrayList<>();
        for (ConferenceDTO conference : relatedConferences) {
            pendingReviews.addAll(paperReviewServices.getPendingReviews(conference.getId()));
        }
        articleList.setListData(pendingReviews.toArray(new PaperReviewItemDTO[0]));
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        // Panel izquierdo: Lista de artículos
        JPanel articlePanel = new JPanel(new BorderLayout());
        articlePanel.setBorder(BorderFactory.createTitledBorder("Artículos Pendientes"));
        articleList = new JList<>();
        articleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        articlePanel.add(new JScrollPane(articleList), BorderLayout.CENTER);
        add(articlePanel, BorderLayout.WEST);

        // Panel central: Área de revisión
        JPanel reviewPanel = new JPanel(new BorderLayout(5, 5));
        JPanel commentPanel = new JPanel(new BorderLayout());
        commentPanel.setBorder(BorderFactory.createTitledBorder("Comentarios"));
        commentsArea = new JCustomTextArea(COMMENT_LIMIT);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        commentPanel.add(new JScrollPane(commentsArea), BorderLayout.CENTER);
        reviewPanel.add(commentPanel, BorderLayout.CENTER);

        // Panel de calificación
        JPanel ratingPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ratingPanel.setBorder(BorderFactory.createTitledBorder("Calificación"));
        String[] ratings = {"1 - Muy Deficiente", "2 - Deficiente", "3 - Regular", "4 - Bueno", "5 - Excelente"};
        ratingCombo = new JComboBox<>(ratings);
        ratingPanel.add(new JLabel("Calificación:"));
        ratingPanel.add(ratingCombo);
        reviewPanel.add(ratingPanel, BorderLayout.SOUTH);

        add(reviewPanel, BorderLayout.CENTER);

        // Panel inferior: Controles de envio
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitButton = new JButton("Enviar Revisión");
        submitButton.addActionListener((ActionEvent e) -> {
            handleReviewSubmission();
        });
        controlPanel.add(submitButton);

        add(controlPanel, BorderLayout.SOUTH);
    }

    // Manejo de la acción de envío
    private void handleReviewSubmission() {
        PaperReviewServices paperReviewServices = AppContext.getInstance().getPaperReviewService();
        String selectedArticle = articleList.getSelectedValue().toString();
        String comments = commentsArea.getText().trim();
        String rating = (String) ratingCombo.getSelectedItem();

        if (selectedArticle == null) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un artículo.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (comments.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, escribe tus comentarios.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Aquí puedes añadir la lógica para guardar la revisión en la base de datos
        ResultChangeStateDTO result = paperReviewServices.changeState(
                articleList.getSelectedValue().getIdPaperReview(),
                SessionContext.getInstance().getUserId(),
                paperReviewServices.PUBLISHED_STATE
        );

        if (!result.isChangeValid()) {            
            JOptionPane.showMessageDialog(this, "Error al enviar la revisión: " + result.getComment(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, "Revisión enviada para \"" + selectedArticle + "\".\nCalificación: "
                + rating + "\nComentarios: " + comments, "Revisión Enviada", JOptionPane.INFORMATION_MESSAGE);

        // Limpiar campos después del envío
        articleList.clearSelection();
        commentsArea.setText("");
        ratingCombo.setSelectedIndex(0);

        // Actualizar la lista de artículos
        loadToReview();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Panel de Revisión de Artículos");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ReviewPanel());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

    }
}
