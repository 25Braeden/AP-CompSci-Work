import java.util.ArrayList;
import java.util.Random;
public class problem1 {
    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>();
        Random random = new Random();
        long runningTotal = 0;
        for(int i = 0; i < random.nextInt(999) + 1; i++) {
            myArray.add(random.nextInt(random.nextInt(300000000)));
        }
        for(int num : myArray) {
            runningTotal += num;
        }
        System.out.println(runningTotal);
    }
}