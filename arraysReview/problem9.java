import java.util.ArrayList;
import java.util.Random;
public class problem9 {
    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>();
        ArrayList<Integer> numsToFour = new ArrayList<>();
        Random random = new Random();

        int indexFour = -1;

        for (int i = 0; i < 10; i ++) {
            if(i < 5) {
                myArray.add(random.nextInt(5));
            }else {
                myArray.add(random.nextInt(i + 1));
            }
        }
        for (int i = 0; i < myArray.size() - 1; i++) {
            if (myArray.get(i) == 4) {
                indexFour = i;
                break;
            }
        }
        
        if (indexFour != -1) {
            System.out.println(myArray);
            for (int i = 0; i < indexFour; i++) {
                numsToFour.add(myArray.get(i));
            }
            System.out.println(numsToFour);
        } else {
            System.out.println(myArray);
            System.out.println("No four in array.");
        }

    }
    
}
