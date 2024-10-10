
import java.util.*;

public class DistanceChart {
  public List<String> cityNames;
  public int[][] distances;
  
  public DistanceChart(List<String> cities) {
    this.cityNames = cities;
    int n = this.cityNames.size();
    this.distances = new int[n][n];
  }

  public int findRemotestCity() {
    int numOfCities = this.cityNames.size();
    int remotestCity = 0;
    int maxDistanceSum = 0;

    for (int i = 0; i < numOfCities; i++) {
      int distanceSum = 0;

      for (int j = 0; j < numOfCities; j++) {
        if (i != j) {
          distanceSum += this.distances[i][j];
        }
      }

      if (distanceSum > maxDistanceSum) {
        maxDistanceSum = distanceSum;
        remotestCity = i;
      }
    }
    return remotestCity;
  }

  public int findNearestCity(int i, boolean[] visited) {
    int nearestCityIndex = -1;
    int minDistance = Integer.MAX_VALUE;

    for (int j = 0; j < this.cityNames.size(); j++) {
      if (!visited[j] && i != j) {
        int distance = distances[i][j];
        if (distance < minDistance) {
          minDistance = distance;
          nearestCityIndex = j;
        }
      }
    }
    return nearestCityIndex;
  }

  public List<String> makeItinerary() {
    List<String> itinerary = new ArrayList<>();
    int numOfCities = this.cityNames.size();

    int currentCityIndex = findRemotestCity();
    itinerary.add(this.cityNames.get(currentCityIndex));

    boolean[] visited = new boolean[numOfCities];
    visited[currentCityIndex] = true;

    for (int i = 1; i < numOfCities; i++) {
      int nearestCityIndex = findNearestCity(currentCityIndex, visited);

      if (nearestCityIndex != -1) {
        itinerary.add(this.cityNames.get(nearestCityIndex));
        visited[nearestCityIndex] = true;
        currentCityIndex = nearestCityIndex;
      }
    }

    return itinerary;
  }
}
