package ballroomDancing;

public class ArrayFunctions {
    public static int countOccurrences(int[] scores, int target) {
        int count = 0;
        for (int score : scores) {
            if (score == target) {
                count++;
            }
        }
        return count;
    }

    public static int[] findMinAndMax(int[] scores) {
        int min = scores[0];
        int max = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            }
            if (scores[i] > max) {
                max = scores[i];
            }
        }
        return new int[]{max, min};
    }

    public static double averageScore(int[] scores) {
        int[] minMax = findMinAndMax(scores);
        int arrayMax = minMax[0];
        int arrayMin = minMax[1];

        int maxCount = countOccurrences(scores, arrayMax);
        int minCount = countOccurrences(scores, arrayMin);

        double sum = 0;
        double count = scores.length;

        for (int score : scores) {
            sum += score;
        }

        if (scores.length >= 6 && maxCount == 1) {
            sum -= arrayMax;
            count--;
        }

        if (scores.length >= 6 && minCount == 1) {
            sum -= arrayMin;
            count--;
        }

        return sum / count;
    }
}
