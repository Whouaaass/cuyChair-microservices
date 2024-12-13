package co.edu.unicauca.cuychair.gui.views;

import javax.swing.JFrame;

import co.edu.unicauca.cuychair.gui.context.SessionContext;
import co.edu.unicauca.cuychair.gui.language.Languagable;
import co.edu.unicauca.cuychair.gui.language.LanguageManager;
import co.edu.unicauca.cuychair.gui.views.components.UserInfo;
import co.edu.unicauca.cuychair.gui.views.styledcontrols.StyledButtonUI;

/**
 * Vista de entrada a la aplicación
 *
 * @author Frdy
 */
public class EntryView extends javax.swing.JFrame implements Languagable {

    /**
     * Creates new form MenuView
     */
    public EntryView() {
        initComponents();
        this.updateLanguage();
        SessionContext.getInstance().getLanguageManager().subscribe(this);
        setUIs();
        this.setResizable(false);
        this.setLocationRelativeTo(null); // this centers the view in the screen
    }

    private void initComponents() {

        BannerPanel = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        InfoPanel = new UserInfo(
                SessionContext.getInstance().getUserMail(),
                SessionContext.getInstance().getUserName()
        );

        OptionsPanel = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20),
                new java.awt.Dimension(32767, 30));
        goConferencesButton = new javax.swing.JButton();
        goPapersButton = new javax.swing.JButton();
        goReviewPapersButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                new java.awt.Dimension(32767, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CuyChair Conference");
        setPreferredSize(new java.awt.Dimension(600, 350));

        BannerPanel.setBorder(
                javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BannerPanel.setPreferredSize(new java.awt.Dimension(280, 369));

        icon.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-md.png"))); // NOI18N

        nameLabel.setFont(new java.awt.Font("Ebrima", 0, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(112, 112, 112));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("CuyChair Conference");

        javax.swing.GroupLayout BannerPanelLayout = new javax.swing.GroupLayout(BannerPanel);
        BannerPanel.setLayout(BannerPanelLayout);
        BannerPanelLayout.setHorizontalGroup(
                BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BannerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLabel,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        401, Short.MAX_VALUE)
                                .addContainerGap())
                        .addComponent(icon, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        BannerPanelLayout.setVerticalGroup(
                BannerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BannerPanelLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(icon)
                                .addGap(18, 18, 18)
                                .addComponent(nameLabel)
                                .addContainerGap(152, Short.MAX_VALUE)));

        getContentPane().add(BannerPanel, java.awt.BorderLayout.CENTER);

        MainPanel.setLayout(new java.awt.BorderLayout());

        MainPanel.add(InfoPanel, java.awt.BorderLayout.PAGE_START);

        goConferencesButton.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        goConferencesButton.setText("Ver Conferencias");
        goConferencesButton.setPreferredSize(new java.awt.Dimension(200, 40));
        goConferencesButton.addActionListener(this::goConferencesButtonActionPerformed);

        goPapersButton.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        goPapersButton.setText("Articulos Enviados");
        goPapersButton.setPreferredSize(new java.awt.Dimension(200, 40));
        goPapersButton.addActionListener(this::goPapersButtonActionPerformed);

        goReviewPapersButton.setFont(new java.awt.Font("Ebrima", 0, 16)); // NOI18N
        goReviewPapersButton.setText("Revisar Articulos");
        goReviewPapersButton.setPreferredSize(new java.awt.Dimension(200, 40));
        goReviewPapersButton.addActionListener(this::goReviewPapersButtonActionPerformed);

        javax.swing.GroupLayout OptionsPanelLayout = new javax.swing.GroupLayout(OptionsPanel);
        OptionsPanel.setLayout(OptionsPanelLayout);
        OptionsPanelLayout.setHorizontalGroup(
                OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(OptionsPanelLayout.createSequentialGroup()
                                .addGroup(OptionsPanelLayout
                                        .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                false)
                                        .addComponent(goReviewPapersButton,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                225, Short.MAX_VALUE)
                                        .addComponent(goPapersButton,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(goConferencesButton,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(filler1,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(filler2,
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)));
        OptionsPanelLayout.setVerticalGroup(
                OptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(OptionsPanelLayout.createSequentialGroup()
                                .addComponent(filler1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(goConferencesButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(goPapersButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(goReviewPapersButton,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(filler2,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        174,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)));

        MainPanel.add(OptionsPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainPanel, java.awt.BorderLayout.LINE_START);

        pack();
    }

    private void setUIs() {
        this.goConferencesButton.setUI(new StyledButtonUI());
        this.goPapersButton.setUI(new StyledButtonUI());
        this.goReviewPapersButton.setUI(new StyledButtonUI());
    }

    @Override
    public final void updateLanguage() {
        LanguageManager lm = SessionContext.getInstance().getLanguageManager();
        String message;
        message = lm.getString("nameLabel");
        if (message != null) {
            nameLabel.setText(message);
        }
        message = lm.getString("goConferencesButton");
        if (message != null) {
            goConferencesButton.setText(message);
        }
        message = lm.getString("goPapersButton");
        if (message != null) {
            goPapersButton.setText(message);
        }
        message = lm.getString("goReviewPapersButton");
        if (message != null) {
            goReviewPapersButton.setText(message);
        }
    }

    private void goReviewPapersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Going to Review Papers");
        JFrame mainView = new MainView("REVIEW_PAPERS");

        mainView.setVisible(true);
        this.dispose();
    }

    private void goPapersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Going to Papers");
        JFrame mainView = new MainView("PAPERS");
        mainView.setVisible(true);
        this.dispose();
    }

    private void goConferencesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Going to Conference");
        JFrame mainView = new MainView("CONFERENCE");

        mainView.setVisible(true);
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EntryView().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel BannerPanel;

    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel OptionsPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton goConferencesButton;
    private javax.swing.JButton goPapersButton;
    private javax.swing.JButton goReviewPapersButton;
    private javax.swing.JLabel icon;
    private UserInfo InfoPanel;

    private javax.swing.JLabel nameLabel;

}
