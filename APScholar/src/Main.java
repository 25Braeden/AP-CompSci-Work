import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        APStudent alice = new APStudent();
        alice.add(new APExam("Calculus BC", 5));
        alice.add(new APExam("Chemistry", 3));
        System.out.println("Alice 0: " + alice.getAwardLevel());
        alice.add(new APExam("Physics", 3));
        alice.add(new APExam("Spanish", 2));
        System.out.println("Alice 1: " + alice.getAwardLevel());

        APStudent bob = new APStudent();
        bob.add(new APExam("Art History", 5));
        bob.add(new APExam("French", 5));
        bob.add(new APExam("Physics", 3));
        bob.add(new APExam("Chemistry", 3));
        bob.add(new APExam("Calculus", 2));
        System.out.println("Bob 2: " + bob.getAwardLevel());
        bob.add(new APExam("Comp Sci", 4));
        System.out.println("Bob 3: " + bob.getAwardLevel());


        List<APStudent> students = new ArrayList<>(
                Arrays.asList(
                        alice, bob
                )
        );

        List<Tuple<String, Double>> studentScores = APStats.getStats(students);
        for (Tuple<String, Double> tuple : studentScores) {
            System.out.printf("%s %.2f\n", tuple.first(), tuple.second());
        }
    }
}