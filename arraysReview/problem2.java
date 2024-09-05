import java.util.ArrayList;
import java.util.Random;

class BubbleSort {
    public ArrayList<Integer> bubbleSort(ArrayList<Integer> array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i ++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array.get(j) > array.get(j + 1)) {
                    int temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                }
            }
        }
        return array;
    }

    public ArrayList<Integer> reverseMe(ArrayList<Integer> startList, ArrayList<Integer> reverseList) {
        for(int i = startList.size() - 1; i >= 0; i--) {
            reverseList.add(startList.get(i));
        }
        return reverseList;
    }
}

public class problem2 {
    public static void main (String[] args) {
        Random random = new Random();
        BubbleSort bubbleSort = new BubbleSort();
        ArrayList<Integer> bigList = new ArrayList<>();
        ArrayList<Integer> reverseList = new ArrayList<>();

        int iterationNum = random.nextInt(25);
        for (int i = 0; i < iterationNum; i++) {
            bigList.add(random.nextInt(25));
        }
        ArrayList<Integer> sortedBigList = bubbleSort.bubbleSort(bigList);
        reverseList = bubbleSort.reverseMe(sortedBigList, reverseList);
        System.out.println(sortedBigList);
        System.out.println(reverseList);
    }
}
