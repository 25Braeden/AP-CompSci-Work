import java.util.ArrayList;


public class Main {
  public static void main(String[] args) {
    SkiArea skiArea = new SkiArea(new int[][] {
        {8, 9, 10, 7},
        {6, 9, 8, 7},
        {4, 5, 6, 6},
        {4, 3, 2, 1}
    });

    System.out.println("Testing indexOfMax:");
    System.out.println("Expected: 2, Actual: " + skiArea.indexOfMax(skiArea.alts[0]));

    System.out.println("Testing rightIndexOfMax:");
    System.out.println("Expected: 2, Actual: " + skiArea.rightIndexOfMax(skiArea.alts[0]));

    System.out.println("Testing findSummit:");
    System.out.println("Expected: 2, Actual: " + skiArea.findSummit());

    System.out.println("Testing findSteepestTrail:");
    ArrayList<Location> steepestTrail = skiArea.findSteepestTrail();
    System.out.println("Expected Steepest Trail: [(0,2), (1,2), (2,2), (3,3)]");
    System.out.print("Actual Steepest Trail: ");
    for (Location loc : steepestTrail) {
        System.out.print("(" + loc.row + "," + loc.column + ") ");
    }
    System.out.println();

    System.out.println("Testing findZigzagTrail:");
    ArrayList<Location> zigzagTrail = skiArea.findZigzagTrail();
    System.out.println("Expected Zigzag Trail: [(0,2), (1,1), (2,2), (3,0)]");
    System.out.print("Actual Zigzag Trail: ");
    for (Location loc : zigzagTrail) {
        System.out.print("(" + loc.row + "," + loc.column + ") ");
    }
    System.out.println();
  }
}

