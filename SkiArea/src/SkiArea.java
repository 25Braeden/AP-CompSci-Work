import java.util.ArrayList;
import java.util.Arrays;

public class SkiArea {
  public int[][] alts;

  public SkiArea(int[][] alts) {
    this.alts = alts;
  }

  public int indexOfMax(int[] array) {
    if (array.length == 0) return -1;
    else {
      int maxIndex = -1;
      for (int i = 1; i < array.length; i++) {
        if (maxIndex == -1 || array[i] > array[maxIndex]) maxIndex = i;
      }
      return maxIndex;
    }
  }

  public int rightIndexOfMax(int[] array) {
    int maxRightIndex = 0;
    if (array.length == 0) return -1;
    else {
      for (int i = 1; i < array.length; i++) {
        if (array[i] >= array[maxRightIndex]) maxRightIndex = i;
      }
    }
    return maxRightIndex;
  }

  public int findSummit() {
    return indexOfMax(this.alts[0]);
  }

  public ArrayList<Location> findSteepestTrail() {
    ArrayList<Location> locations = new ArrayList<>();
    int currentRow = 0;
    int currentCol = findSummit();
    locations.add(new Location(currentRow, currentCol));
    while (currentRow < this.alts.length - 1) {
      currentCol = nextSlope(currentRow, currentCol);
      currentRow++;
      locations.add(new Location(currentRow, currentCol));
    }
    return locations;
  }

  /* helper method for findSteepestTrail please dont yell at me Mr. Schmitt */
  public int nextSlope(int row, int col) {
    int bestCol = col;
    
    if (row < this.alts.length - 1) {
      int bestAltitude = this.alts[row + 1][col];

      if (col > 0 && this.alts[row + 1][col - 1] < bestAltitude) {
        bestCol = col - 1;
        bestAltitude = this.alts[row + 1][bestCol];
      }

      if (col < alts[0].length - 1 && this.alts[row + 1][col + 1] < bestAltitude) {
        bestCol = col + 1;
      }
    }
    return bestCol;
  }

  public ArrayList<Location> findZigzagTrail() {
    ArrayList<Location> locations = new ArrayList<>();
    boolean isLeftMax = false;
    
    int currentRow = 0;
    int currentCol = indexOfMax(this.alts[0]);
    locations.add(new Location(currentRow, currentCol));

    for (int i = 1; i < this.alts.length; i++) {
      Location nextLocation = nextZigzagTrail(currentRow, isLeftMax);
      locations.add(nextLocation);
      currentRow++;
      isLeftMax = !isLeftMax;
    }
    return locations;
  }

  /* Mr. Schmitt helper methods is just me making my code more readable and should be aloud fr */
  public Location nextZigzagTrail(int lastRow, boolean isLeftMax) {
    if (isLeftMax) return new Location(lastRow + 1, indexOfMax(this.alts[lastRow + 1]));
    else return new Location(lastRow + 1, rightIndexOfMax(this.alts[lastRow + 1]));
  }
}
