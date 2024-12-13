package co.edu.unicauca.cuychair.gui.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class DateUtils {

    // ISO 8601 date formatter
    private static final SimpleDateFormat isoDateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");;

    // Custom pretty date formatter
    private static final SimpleDateFormat prettyDateFormatter = new SimpleDateFormat("EEEE, MMMM d, yyyy");
    
    static {        
        isoDateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    }    

    /**
     * Formats a date to ISO 8601 format.
     *
     * @param date The date to format.
     * @return The formatted date string.
     */
    public static String formatToISO(Date date) {
        return isoDateFormatter.format(date);
    }

    /**
     * Formats a date to a pretty string format.
     *
     * @param date The date to format.
     * @return The formatted date string.
     */
    public static String formatToPrettyDate(Date date) {
        return prettyDateFormatter.format(date);
    }

    public static DateFormat getIsoDateFormatter() {
        return isoDateFormatter;
    }

    public static DateFormat getPrettyDateFormatter() {
        return prettyDateFormatter;
    }    

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Date now = new Date();

        System.out.println("ISO Date: " + formatToISO(now));
        System.out.println("Pretty Date: " + formatToPrettyDate(now));
    }
}
