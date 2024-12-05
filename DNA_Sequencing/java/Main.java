import java.util.*;

public class Main {
    public static boolean isValidDNA(String str) {
        String validChars = "ACTG";
        for (char c : str.toCharArray()) {
            if (!validChars.contains(String.valueOf(c).toUpperCase())) {
                return false;
            }
        }
        return true;
    }

    public static int matchGenes(String dnaString, String[] genes) {
        int lastIndex = 0;
        int gapSum = 0;
        for (String gene : genes) {
            int index = dnaString.indexOf(gene, lastIndex);
            if (index == -1) return -1;
            if (index <= lastIndex) return -1;
            gapSum += (index - lastIndex);
            lastIndex = index + gene.length();
        }
        return gapSum;
    }

    private static final HashMap<Character, String> encodeMap = new HashMap<>();
    static {
        encodeMap.put('A', "00");
        encodeMap.put('C', "01");
        encodeMap.put('G', "10");
        encodeMap.put('T', "11");
    }

    private static final HashMap<String, Character> decodeMap = new HashMap<>();
    static {
        decodeMap.put("00", 'A');
        decodeMap.put("01", 'C');
        decodeMap.put("10", 'G');
        decodeMap.put("11", 'T');
    }

    public static String encode(String dnaSegment) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : dnaSegment.toCharArray()) {
            encodedString.append(encodeMap.get(c));
        }
        return encodedString.toString();
    }

    public static String decode(String encodedValue, int length) {
        StringBuilder decodedString = new StringBuilder();
        for (int i = 0; i < encodedValue.length(); i += 2) {
            String binaryChunk = encodedValue.substring(i, i + 2);
            decodedString.append(decodeMap.get(binaryChunk));
        }
        return decodedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(isValidDNA("ACTG"));
        String encodedDNA = encode("GTACCGTA");
        System.out.println(encodedDNA);
        System.out.println(decode(encodedDNA, 8));
    }
}
