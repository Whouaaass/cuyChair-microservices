package co.edu.unicauca.cuychair.gui.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
 
import javax.swing.JFormattedTextField.AbstractFormatter;
 
public class DateLabelFormatter extends AbstractFormatter {
 
    private String datePattern = "yyyy-MM-dd";
    private DateFormat dateFormatter = DateUtils.getPrettyDateFormatter();
     
    @Override
    public Object stringToValue(String text) throws ParseException {
        return dateFormatter.parseObject(text);
    }
 
    @Override
    public String valueToString(Object value) throws ParseException {
        if (value != null) {
            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());
        }
         
        return "";
    }
 
}