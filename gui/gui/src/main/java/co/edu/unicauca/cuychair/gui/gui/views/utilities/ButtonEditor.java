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
import co.edu.unicauca.cuychair.gui.gui.DTO.PaperDTO;
import java.util.List;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
    private final JPanel panel;
    private final JButton editButton;
    private final JButton deleteButton;

    public ButtonEditor(JTable table, List<PaperDTO> papers) {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editButton = new JButton("Editar");
        deleteButton = new JButton("Eliminar");

        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                PaperDTO paper = papers.get(row);
                // Lógica de edición
                JOptionPane.showMessageDialog(null, "Editar producto: " + paper.getTitle());
                fireEditingStopped();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                PaperDTO paper = papers.get(row);
                // Lógica de eliminación
                JOptionPane.showMessageDialog(null, "Eliminar producto: " + paper.getTitle());
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

