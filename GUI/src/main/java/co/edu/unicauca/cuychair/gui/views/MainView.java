package co.edu.unicauca.cuychair.gui.views;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import co.edu.unicauca.cuychair.gui.context.SessionContext;
import co.edu.unicauca.cuychair.gui.views.components.UserInfo;
import co.edu.unicauca.cuychair.gui.views.controllers.JPanelButton;
import co.edu.unicauca.cuychair.gui.views.panels.AuthorPanel;
import co.edu.unicauca.cuychair.gui.views.panels.ConferencePanel;
import co.edu.unicauca.cuychair.gui.views.panels.ReviewPanel;
import co.edu.unicauca.cuychair.gui.views.panels.UserPanel;

/**
 * Vista principal de la aplicación, es como un home
 *
 * @author Frdy
 */
public class MainView extends javax.swing.JFrame {

    private SelectedView selectedView = null;

    public MainView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public MainView(String viewId) {
        SelectedView selection = SelectedView.valueOf(viewId);
        initComponents();
        setLocationRelativeTo(null);
        selectView(selection);
    }

    private void initComponents() {

        headerPanel = new JPanel();
        navigationPanel = new JPanel();
        viewPanel = new JPanel();
        jButton1 = new JButton("Conferencias");
        jButton2 = new JButton("Articulos");
        jButton3 = new JButton("Review Papers");
        userInfo = new UserInfo(SessionContext.getInstance().getUserMail(), SessionContext.getInstance().getUserName());
        JPanelButton userInfoDeco = new JPanelButton(userInfo);
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPopupMenu popupMenu = new JPopupMenu("Opciones");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));

        // Header 
        headerPanel.setLayout(new BorderLayout());
        headerPanel.add(navigationPanel, BorderLayout.CENTER);
        headerPanel.add(userPanel, BorderLayout.LINE_END);

        // User panel        
        userPanel.add(userInfoDeco);

        // User menu        
        JMenuItem editProfile = new JMenuItem("Editar perfil");
        JMenuItem logout = new JMenuItem("Cerrar sesión");
        popupMenu.add(editProfile);
        popupMenu.add(logout);
        editProfile.addActionListener(l -> {
            selectView(SelectedView.USER);
            popupMenu.setVisible(false);
        });
        

        //User info tweak
        userInfoDeco.setListeners(
                e -> popupMenu.show(userInfo, 0, userInfoDeco.getHeight()),
                null
        );
        

        // Panel with the navigation
        navigationPanel.setLayout(new BoxLayout(navigationPanel, BoxLayout.LINE_AXIS));
        navigationPanel.add(jButton1);
        navigationPanel.add(jButton2);
        navigationPanel.add(jButton3);
        jButton1.addActionListener(evt -> selectView(SelectedView.CONFERENCE));
        jButton2.addActionListener(evt -> selectView(SelectedView.PAPERS));
        jButton3.addActionListener(evt -> selectView(SelectedView.REVIEW_PAPERS));


        viewPanel.setLayout(new CardLayout());

        add(headerPanel, BorderLayout.PAGE_START);
        add(viewPanel, BorderLayout.CENTER);

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new MainView().setVisible(true));
    }

    /**
     * Selecciona la vista a mostrar
     *
     * @param selectedView vista a mostrar
     */
    private void selectView(SelectedView selectedView) {
        CardLayout cardLay = (CardLayout) viewPanel.getLayout();
        if (!selectedView.hasBeenGotted()) {
            viewPanel.add(selectedView.getPanel(), selectedView.getId());
        }
        cardLay.show(viewPanel, selectedView.getId());
        this.selectedView = selectedView;

        viewPanel.validate();

        // cambia el titulo de la ventana
        this.setTitle(selectedView.getId());
        pack();
    }

    private enum SelectedView {
        CONFERENCE("Conference"),
        PAPERS("Papers"),
        REVIEW_PAPERS("ReviewPapers"),
        USER("User");

        private final String id;
        private JPanel panel; // panel seleccionado

        private final static Map<String, JPanel> panelsGotted = new HashMap<>(3);

        private SelectedView(String id) {
            this.id = id;
            panel = null;
        }

        public JPanel getPanel() {
            if (panelsGotted.containsKey(id)) {
                return panel;
            }
            switch (id) {
                case "Conference" ->
                    panel = new ConferencePanel();
                case "Papers" ->
                    panel = new AuthorPanel();
                case "ReviewPapers" ->
                    panel = new ReviewPanel();
                case "User" ->
                    panel = new UserPanel();
            }
            panelsGotted.put(id, panel);
            return panel;
        }

        public boolean hasBeenGotted() {
            return panelsGotted.containsKey(id);
        }

        public String getId() {
            return id;
        }
    }

    // Componentes 
    private JPanel navigationPanel;
    private JPanel headerPanel;
    private JPanel viewPanel;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel userInfo;
}
