package co.edu.unicauca.cuychair.gui.views.components;

import javax.swing.JFrame;

/**
 * Item de paper
 * @author Frdy
 */
public class PaperItem extends javax.swing.JPanel {

    /**
     * Genera un nuevo item de paper
     * @param title titulo del paper
     * @param brief descripcion del paper
     * @param status estado del paper
     */
    public PaperItem(String title, String brief, String status) {
        initComponents();
        titleLabel.setText(title);
        briefLabel.setText("<html>" + brief + "</html>");
        statusLabel.setText(status);
    }

    /**
     * Inicializa los componentes de la vista
     */
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        briefLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(400, 70));

        titleLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        titleLabel.setText("Title");

        briefLabel.setText("brief");
        briefLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        statusLabel.setText("Status");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(briefLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(statusLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(briefLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );
    }

    public static void main(String[] args) {
        PaperItem paperItem = new PaperItem("Paper Title", "Paper Brief", "Paper Status");
        JFrame frame = new JFrame();
        frame.add(paperItem);
        frame.pack();
        frame.setVisible(true);
    }

    private javax.swing.JLabel briefLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel titleLabel;
}
