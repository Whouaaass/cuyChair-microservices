package co.edu.unicauca.cuychair.gui.views.controllers;

import javax.swing.JTextArea;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Esta es una clase que extiende JTextArea y limita la cantidad de caracteres que se pueden ingresar.
 */
public class JCustomTextArea extends JTextArea {

    /**
     * Crea una nueva instancia de JCustomTextArea con un tamaño máximo de caracteres.
     * @param maxSize tamaño máximo de caracteres
     */
    public JCustomTextArea(int maxSize) {
        super();
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new DocumentSizeFilter(maxSize));
    }

    private static class DocumentSizeFilter extends DocumentFilter {
        private final int maxCharacters;

        public DocumentSizeFilter(int maxChars) {
            maxCharacters = maxChars;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (fb.getDocument().getLength() + string.length() <= maxCharacters) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (fb.getDocument().getLength() + text.length() - length <= maxCharacters) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}