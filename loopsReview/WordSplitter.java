import java.util.Scanner;
public class WordSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentance: ");

        String userInput = scanner.nextLine();
        
        String[] withQuotation = userInput.trim().split("\\s+");
        
        String clearedInput = userInput.replaceAll("[^a-zA-Z0-9]", " ");
        String[] words = clearedInput.split("\\s+");
        
        for (String word : words) {
            System.out.println(word);
        }
        
        for (String word : withQuotation) {
            System.out.println(word);
        }
        
        scanner.close();
    }
    
}
