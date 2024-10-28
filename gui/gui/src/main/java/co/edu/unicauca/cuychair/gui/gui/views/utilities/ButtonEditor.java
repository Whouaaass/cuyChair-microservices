/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.views.utilities;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unicauca.cuychair.gui.gui.Context.AppContext;
import co.edu.unicauca.cuychair.gui.gui.DTO.PaperDTO;
import co.edu.unicauca.cuychair.gui.gui.services.PaperServices;
import co.edu.unicauca.cuychair.gui.gui.views.ViewEditPaper;

import java.util.List;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton editButton;
    private final JButton deleteButton;
    private PaperServices servicesPaper;

    public ButtonEditor(JTable table, List<PaperDTO> papers) {
        AppContext appContext = AppContext.getInstance();
        servicesPaper = appContext.getPaperService();
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                PaperDTO paper = papers.get(row);
                // Lógica de edición
                JOptionPane.showMessageDialog(null, "Editar producto: " + paper.getTitle());
                ViewEditPaper viewPaper = new ViewEditPaper(paper);
                viewPaper.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                viewPaper.setVisible(true);
                fireEditingStopped();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                PaperDTO paper = papers.get(row);
                // Lógica de eliminación
                servicesPaper.deletePaper(paper);
                JOptionPane.showMessageDialog(null, "Paper Eliminado: " + paper.getTitle());
                fireEditingStopped();
            }
        });

        panel.add(editButton);
        panel.add(deleteButton);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}

