import java.util.*;
public class test {
  public static void main(String[] args) {
    String[] cities = {"Atlanta", "Boston", "Cleveland", "Dallas", "Washington"};
    DistanceChart chart = new DistanceChart(Arrays.asList(cities));

    int[][] d =
    {{0, 936, 550, 719, 540},
     {936, 0, 554, 1547, 396},
     {550, 554, 0, 1018, 309},
     {719, 1547, 1018, 0, 1181},
     {540, 396, 309, 1181, 0}};

    for (int i = 0; i < cities.length; i++) {
      for (int j = 0; j < cities.length; j++) {
        chart.distances[i][j] = d[i][j]; 
      }
    }
    System.out.println(chart.makeItinerary());
  }
}
