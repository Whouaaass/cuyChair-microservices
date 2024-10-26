/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.cuychair.gui.gui.views.utilities;

import co.edu.unicauca.cuychair.gui.gui.DTO.PaperDTO;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author usuario
 */
public class ListPaperModel extends AbstractTableModel{
    private final String[] columnNames = {"Titulo", "Resumen", "Subtitulo","Acciones"};
    private final List<PaperDTO> papers;

    public ListPaperModel(List<PaperDTO> papers) {
        this.papers=papers;
    }

    @Override
    public int getRowCount() {
        return papers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PaperDTO paper = papers.get(rowIndex);
        switch (columnIndex) {
            case 0: return paper.getTitle();
            case 1: return paper.getAbstract();
            case 2: return paper.getSubTitle();
            case 3: return "Editar / Eliminar"; // Texto genérico para los botones
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3; // Solo la columna de acciones es editable
    }
    
}
