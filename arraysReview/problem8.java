import java.util.ArrayList;

public class problem8 {
    
    public static boolean foundThree(ArrayList<Integer> array) {
        int ticker = 0;
        for(int i = 0; i < array.size() - 1; i++) {
            int temp = array.get(i);
            for (int j = 0; j < array.size() - 1; j++) {
                if(array.get(j) == temp && j != i) {
                    ticker++;
                    if (ticker == 2) {
                        return true;
                    }
                }
            }
            ticker = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> myArray = new ArrayList<>();
        myArray.add(1);
        myArray.add(12);
        myArray.add(12);
        myArray.add(13);
        myArray.add(11);
        myArray.add(12);
        myArray.add(15);
        boolean found = foundThree(myArray);
        System.out.println(found);
    }
}
