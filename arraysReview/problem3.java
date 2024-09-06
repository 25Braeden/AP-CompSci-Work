import java.util.Arrays;

public class problem3 {
    public static void main(String[] args) {
        int[] arrayOne = {1, 2, 3, 4, 5};
        int[] arrayDoubled = new int[arrayOne.length * 2];

        int lastIndex = arrayOne.length - 1;
        for (int i = 0; i < arrayDoubled.length - 1; i++) {
            try {
                arrayDoubled[i] = arrayOne[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                arrayDoubled[i] = 0;
            }
        }
        arrayDoubled[arrayDoubled.length - 1] = arrayOne[lastIndex];
        System.out.println(Arrays.toString(arrayDoubled));
    }
}