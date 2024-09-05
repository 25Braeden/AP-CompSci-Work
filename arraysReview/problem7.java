import java.util.ArrayList;
import java.util.Random;
public class problem7 {
    
    public static boolean hasOneOrThree(ArrayList<Integer> array) {
        for (int num: array) {
            if (num == 1 || num == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            myList.add(random.nextInt(10));
        }
        boolean found = hasOneOrThree(myList);
        System.out.println(found);
        System.out.println(myList);
    }
}
