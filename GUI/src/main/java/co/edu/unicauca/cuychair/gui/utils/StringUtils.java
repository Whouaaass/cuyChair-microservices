package co.edu.unicauca.cuychair.gui.utils;


/**
 * Utility class for string manipulation.
 */
public class StringUtils {
    /**
     * Truncates a string and adds ellipses if it exceeds the specified length.     *
     * @param text   The input string to truncate.
     * @param maxLength The maximum allowed length.
     * @return The truncated string with ellipses if it exceeds the length.
     */
    public static String truncateWithEllipsis(String text, int maxLength) {
        if (text == null || text.length() <= maxLength) {
            return text; // Return the original string if it's within the limit
        }

        // Ensure the ellipsis fits within the maximum length
        if (maxLength <= 3) {
            return text.substring(0, maxLength); // Not enough space for ellipsis
        }

        return text.substring(0, maxLength - 3) + "...";
    }

    
    public static void main(String[] args) {
        // Test examples        

        String longString = "This is a very long string that needs to be truncated.";
        String shortString = "Short";

        System.out.println(truncateWithEllipsis(longString, 20)); // Output: "This is a very lo..."
        System.out.println(truncateWithEllipsis(shortString, 20)); // Output: "Short"
        System.out.println(truncateWithEllipsis(longString, 2));  // Output: "Th"
    }
}
