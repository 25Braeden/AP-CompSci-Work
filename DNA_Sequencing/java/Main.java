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

    // Reddit said allowed on AP Exam, maybe. Idk Mr. Schmidt this seems required to me
    private static HashMap<Character, Integer> encodeMap = new HashMap<>();
    static {
        encodeMap.put('A', 0b00);
        encodeMap.put('C', 0b01);
        encodeMap.put('G', 0b10);
        encodeMap.put('T', 0b11);
    }
    private static HashMap<Integer, Character> decodeMap = new HashMap<>();
    static {
        decodeMap.put(0b00, 'A');
        decodeMap.put(0b01, 'C');
        decodeMap.put(0b10, 'G');
        decodeMap.put(0b11, 'T');
    }

    public static int encode(String dnaSegment) {
        int encodedValue = 0;
        for (char c : dnaSegment.toCharArray()) {
            encodedValue <<= 2;
            encodedValue |= encodeMap.get(c);
        }
        return encodedValue;
    }
    public static String decode(int encodedValue, int length) {
        String decodedString = "";
        for (int i = 0; i < length; i++) {
            int lastTwoBits = encodedValue & 0b11;
            decodedString = decodeMap.get(lastTwoBits) + decodedString;
            encodedValue >>= 2;
        }
        return decodedString;
    }
    public static void main(String[] args) {
        System.out.println(isValidDNA("ACTG"));
        /*
        Mr. Schmidt I really cannot figure out how to fix getting 45420 instead of 36204 when encoding
        and decoding. I feel like I'm doing something right at least because the print values are almost the
        exact same but I don't know how to fix it.
         */
        System.out.println(encode("GTACCGTA"));
        System.out.println(decode(36204, 8));
        System.out.println(decode(45420, 8));
    }
}