import java.util.ArrayList;
import java.util.List;

public class Main {
    // Don't need to make them final, just wanted to. Text is my template that will get modified.
    private static final List<String> savedText = new ArrayList<String>();
    private static final String text = "never say never";

    public static String replaceOne(String text, int i, int n, String sub) {
        return text.substring(0, i) + sub + text.substring(i + n);
    }
    // Replaces all text in a string
    public static String replaceAll(String text, String what, String sub) {
        String currentText = text;
        // Add to saveText so I can call undoReplaceAll()
        savedText.add(text);
        // Find index of first word occurrence
        int startIndex = text.indexOf(what);
        // If .indexOf() cannot find word, it returns -1
        while(startIndex != -1) {
            // Replace first instance of word. Conforming to replaceOne parameters
            currentText = replaceOne(currentText, startIndex, what.length(), sub);
            // Searches for next occurrence of the word
            startIndex = currentText.indexOf(what);
        }
        return currentText;
    }
    public static String undoReplaceAll() {
        if(savedText.isEmpty()) {
            return null;
        } else {
            String temp = savedText.getLast();
            savedText.removeLast();
            return temp;
        }
    }

    public static void main(String[] args) {
        String modifiedSometimes = replaceAll(text, "never", "sometimes");
        String doubleModded = replaceAll(modifiedSometimes, "say", "think");
        String undoOnce = undoReplaceAll();
        String undoTwo = undoReplaceAll();
        String pleaseBeNull = undoReplaceAll();
        System.out.println(text);
        System.out.println(modifiedSometimes);
        System.out.println(doubleModded);
        System.out.println(undoOnce);
        System.out.println(undoTwo);
        System.out.println(pleaseBeNull);
    }
}
