/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.views;

/**
 *
 * @author julia
 */
public class ViewPrincipalMenu extends javax.swing.JFrame {

    /**
     * Creates new form ViewPrincipalMenu
     */
    public ViewPrincipalMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelMainTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonConferences = new javax.swing.JButton();
        jButtonPapers = new javax.swing.JButton();
        jButtonProfile = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBarMain = new javax.swing.JMenuBar();
        jMenuPerfil = new javax.swing.JMenu();
        jMenuCheckProfile = new javax.swing.JMenuItem();
        jMenuItemEditProfile = new javax.swing.JMenuItem();
        jMenuItemLogOut = new javax.swing.JMenuItem();
        jMenuConferencias = new javax.swing.JMenu();
        jMenuItemConferences = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelMainTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelMainTitle.setForeground(new java.awt.Color(199, 213, 224));
        jLabelMainTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMainTitle.setText("MENU PRINCIPAL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelMainTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMainTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jButtonExit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonExit.setText("Salir");

        jButtonConferences.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonConferences.setText("Conferencias");

        jButtonPapers.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonPapers.setText("Papers");

        jButtonProfile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonProfile.setText("Perfil");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/PosibleLogo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonConferences, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPapers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jButtonProfile)
                .addGap(18, 18, 18)
                .addComponent(jButtonConferences)
                .addGap(18, 18, 18)
                .addComponent(jButtonPapers)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenuPerfil.setText("Perfil");

        jMenuCheckProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuCheckProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user_7099740.png"))); // NOI18N
        jMenuCheckProfile.setText("Ver perfil");
        jMenuPerfil.add(jMenuCheckProfile);

        jMenuItemEditProfile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/profile_14551139.png"))); // NOI18N
        jMenuItemEditProfile.setText("Editar perfil");
        jMenuPerfil.add(jMenuItemEditProfile);

        jMenuItemLogOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/log-out_10024482.png"))); // NOI18N
        jMenuItemLogOut.setText("Salir");
        jMenuPerfil.add(jMenuItemLogOut);

        jMenuBarMain.add(jMenuPerfil);

        jMenuConferencias.setText("Conferencias");

        jMenuItemConferences.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemConferences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/presentation_426378.jpg"))); // NOI18N
        jMenuItemConferences.setText("Conferencias");
        jMenuConferencias.add(jMenuItemConferences);

        jMenuBarMain.add(jMenuConferencias);

        jMenu1.setText("Papers");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/square_14034302.png"))); // NOI18N
        jMenuItem1.setText("Subir articulo");
        jMenu1.add(jMenuItem1);

        jMenuBarMain.add(jMenu1);

        setJMenuBar(jMenuBarMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConferences;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonPapers;
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelMainTitle;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBarMain;
    private javax.swing.JMenuItem jMenuCheckProfile;
    private javax.swing.JMenu jMenuConferencias;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemConferences;
    private javax.swing.JMenuItem jMenuItemEditProfile;
    private javax.swing.JMenuItem jMenuItemLogOut;
    private javax.swing.JMenu jMenuPerfil;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
