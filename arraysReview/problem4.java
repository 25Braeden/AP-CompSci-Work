import java.util.ArrayList;
public class problem4 {

    public static boolean checkLists (ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        for(int i = 0; i < arr1.size(); i++) {
            int temp = arr1.get(i);
            for(int j = 0; j < arr2.size(); j++) {
                if (arr2.get(j) == temp) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayOne = new ArrayList<>();
        ArrayList<Integer> arrayTwo = new ArrayList<>();
        ArrayList<Integer> arrayThree = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayOne.add(i);
            arrayTwo.add(i + 9);
            arrayThree.add((i + 15) * 2);
        }
        String output = (checkLists(arrayOne, arrayTwo)) ? "The lists share a number" : "The lists don't share a number";
        System.out.println(output);
        String output2 = (checkLists(arrayOne, arrayThree)) ? "The lists share a number" : "The lists don't share a number";
        System.out.println(output2);
        
    }
}