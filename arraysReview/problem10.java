import java.util.Arrays;

public class problem10 {
    public static void main(String[] args) {
        int[] array = {1, 10, 3, 10, 10, 4, 5};
        int target = 10;
        
        moveTargetToEnd(array, target, 0);
        System.out.println(Arrays.toString(array));
    }

    public static void moveTargetToEnd(int[] array, int target, int startIndex) {
        if (startIndex >= array.length - 1) {
            return;
        }

        if (array[startIndex] == target) {
            array[startIndex] = 0;
            shiftLeft(array, startIndex + 1);
            moveTargetToEnd(array, target, startIndex);
        } else {
            moveTargetToEnd(array, target, startIndex + 1);
        }
    }

    public static void shiftLeft(int[] array, int index) {
        if (index >= array.length) {
            return;
        }

        array[index - 1] = array[index];

        if (index == array.length - 1) {
            array[index] = 0;
        }

        shiftLeft(array, index + 1);
    }
}
