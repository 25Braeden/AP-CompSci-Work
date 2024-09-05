import java.util.ArrayList;
public class problem5 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            myList.add(i);
        }
        int firstNum = myList.get(0);
        int median = myList.get((myList.size() / 2) + 1);
        int lastNum = myList.get(myList.size() - 1);

        if (lastNum > firstNum && lastNum > median) {
            System.out.println(lastNum);
        } else if (median > firstNum && median > lastNum) {
            System.out.println(median);
        } else if (firstNum > median && firstNum > lastNum) {
            System.out.println(firstNum);
        }
    }
    
}
