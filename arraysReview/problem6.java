import java.util.ArrayList;
import java.util.Random;
public class problem6 {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        ArrayList<Integer> myArray = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            myArray.add(random.nextInt(200000000));
        }
        myArray = bubbleSort.bubbleSort(myArray);
        int arrayRange = myArray.get(myArray.size() - 1) - myArray.get(0);
        System.out.println(arrayRange);
        System.out.println(myArray.get(0) + " " + myArray.get(myArray.size() - 1));
    }
}
