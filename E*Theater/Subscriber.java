import java.util.List;
import java.util.ArrayList;

public class Subscriber {
  // todo in removeOutliers:
  // calculate averages
  // remove all movies who are less than HALF the average simalarity
  // size of movies list NOT less than 2
  public static void removeOutliers(List<Movie> movies) {
    double[] coefficientList = getFitCoefficients(movies);
    double totalScore = 0;
    for (double score : coefficientList) {
      totalScore += score;
    }
    double average = totalScore / movies.size();
    for (int i = 0; i < movies.size(); i++) {
      if (coefficientList[i] < average / 2) {
          movies.remove(i);
      }
    }
  }

  // average of the likeness scores between M and all other movies in list
  // nested for loop?
  // if had autocomplete could do fancy stream stuff...
  // add together averages into ArrayList<Double>, then do Arrays.asList(ArrayList);
  // or could make new double[movies.size()] then manually set;


  private static double[] getFitCoefficients(List<Movie> movies) {
    double[] averageList = new double[movies.size()];
    for (int i = 0; i < movies.size() - 1; i++) {
      Movie currrentMovie = movies.get(i);
      for (int j = i + 1; j < movies.size(); j++) {
        double score = movies.get(j).likenessScore(movies.get(i));
        averageList[i] += score;
        averageList[j] += score;
      }
    }

    for (int i = 0; i < movies.size(); i++) {
      averageList[i] /= (movies.size() - 1);
    }
    return averageList;
  }

  public static void main(String[] args)
  {
    List<Movie> movies = new ArrayList<Movie>();
    movies.add(new Movie("AAABBBCCCDDD"));
    movies.add(new Movie("AAABBBCCCDDD"));
    movies.add(new Movie("AAABBBXXXDDD"));
    movies.add(new Movie("XXXXXXXXXXXX"));
    movies.add(new Movie("AAAXXXCCCDDD"));
    movies.add(new Movie("XXXBBBCCCDDD"));
    movies.add(new Movie("YYYYYYYYYYYY"));

    double[] coeffs = getFitCoefficients(movies);
    for (double c : coeffs)
      System.out.printf("%7.3f", c);
    System.out.println();
    System.out.println(movies);
    removeOutliers(movies);
    System.out.println(movies);
  }
}
