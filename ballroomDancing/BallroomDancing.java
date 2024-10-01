package ballroomDancing;

import java.util.Random;

public class BallroomDancing {
    static final int NUM_COUPLES = 10;
    static final int NUM_EVENTS = 3;
    static final int NUM_JUDGES = 8;
    static final int MIN_SCORE = 90;
    static final int MAX_SCORE = 99;

    public static void main(String[] args) {
        int[] totalScores = new int[NUM_COUPLES];
        Random random = new Random();

        for (int couple = 0; couple < NUM_COUPLES; couple++) {
            int total = 0;
            System.out.println("Couple #" + (couple + 1) + ":");
            for (int event = 0; event < NUM_EVENTS; event++) {
                int[] scores = new int[NUM_JUDGES];
                for (int judge = 0; judge < NUM_JUDGES; judge++) {
                    scores[judge] = random.nextInt(MAX_SCORE - MIN_SCORE + 1) + MIN_SCORE;
                }

                double avg = ArrayFunctions.averageScore(scores);
                total += Math.round(avg);
                System.out.print("   Event " + (event + 1) + " ");
                System.out.print(java.util.Arrays.toString(scores) + " Avg = " + String.format("%.2f", avg) + "\n");
            }
            totalScores[couple] = total;
            System.out.println("Total score: " + total + "\n");
        }

        int bestScore = 0;
        int countBest = 0;

        for (int score : totalScores) {
            if (score > bestScore) {
                bestScore = score;
                countBest = 1;
            } else if (score == bestScore) {
                countBest++;
            }
        }

        System.out.println("Final scores:");
        for (int score : totalScores) {
            System.out.print(score + " ");
        }
        System.out.println("\nBest score: " + bestScore + " Shared by " + countBest + " winners.");
    }
}
