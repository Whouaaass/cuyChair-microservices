package co.edu.unicauca.cuychair.gui.views.panels;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import co.edu.unicauca.cuychair.gui.api.dtos.conferenceAPI.ConferenceDTO;
import co.edu.unicauca.cuychair.gui.api.dtos.paperReviewAPI.PaperReviewResDTO;
import co.edu.unicauca.cuychair.gui.context.AppContext;
import co.edu.unicauca.cuychair.gui.context.SessionContext;
import co.edu.unicauca.cuychair.gui.views.components.GoBackWrapper;

/**
 * Panel para mostrar los artículos enviados por un autor
 *
 * @author Frdy
 */
public class AuthorPanel extends JPanel {

    private JTable articlesTable; // Tabla para mostrar artículos
    private JButton newSubmissionButton; // Botón para enviar un nuevo artículo
    private JButton refreshButton; // Add new button declaration
    private static PaperReviewResDTO paperReviewDTO = null;
    private static ConferenceDTO conferenceDTO = null;

    private JPanel mainContentPanel;

    private CardLayout layout;

    public AuthorPanel() {
        initComponents();
        refreshTableData(); // Initial data load
    }

    /**
     * Inicializa los componentes del panel
     */
    private void initComponents() {
        setLayout(new CardLayout());
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(new BorderLayout(10, 10));
        mainContentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Modelo para la tabla de artículos
        String[] columnNames = {"Nombre del Artículo", "Conferencia", "Estado"};
        Object[][] data = {
            {"Inteligencia Artificial Avanzada", "Conferencia de IA 2024", "En Revisión"},
            {"Sistemas Distribuidos Modernos", "Conferencia de Computación 2024", "Aceptado"},
            {"Bases de Datos Escalables", "Conferencia de Software 2024", "Rechazado"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas sean no editables
            }
        };

        articlesTable = new JTable(tableModel);
        articlesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(articlesTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Artículos Enviados"));
        mainContentPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel inferior con botones
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        refreshButton = new JButton("Actualizar");
        refreshButton.addActionListener(e -> refreshTableData());
        newSubmissionButton = new JButton("Enviar Nuevo Artículo");
        newSubmissionButton.addActionListener(this::handleNewSubmission);
        bottomPanel.add(refreshButton);
        bottomPanel.add(newSubmissionButton);
        mainContentPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Crear panel para enviar nuevo artículo
        GoBackWrapper createPaperWrapper = new GoBackWrapper(new CreatePaperPanel());
        createPaperWrapper.addBackButtonActionListener(this::handleGoBack);

        add(createPaperWrapper, "createPaper");

        add(mainContentPanel, "mainContent");

        layout = (CardLayout) getLayout();
        layout.show(this, "mainContent");
    }

    private void refreshTableData() {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Nombre del Artículo", "Conferencia", "Estado"},
            0
        );
        AppContext.getInstance().getPaperService().getPapersByAuthor(SessionContext.getInstance().getUserId()).forEach(paper -> {
            model.addRow(new Object[]{
                paper.getTitle(),
                (conferenceDTO = AppContext.getInstance().getConferenceService().getConference(paper.getIdConference())) != null ? conferenceDTO.getTitle() : null,
                (paperReviewDTO = AppContext.getInstance().getPaperReviewService().getPaperReview(paper.getId())) != null ? paperReviewDTO.getState().getType() : null
            });
        });
        articlesTable.setModel(model);
    }

    // Método para manejar la acción de nuevo envío
    private void handleNewSubmission(ActionEvent e) {
        layout.show(this, "createPaper");
    }

    private void handleGoBack(ActionEvent e) {
        layout.previous(this);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel del Autor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new AuthorPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
