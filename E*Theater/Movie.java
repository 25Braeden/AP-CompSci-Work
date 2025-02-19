public class Movie {
  private String features;
  
  public Movie(String features) {
    this.features = features;
  }

  // The likeness score of two movies is defined as the number of matching features, divided by the total number of features.
  // The lengths of the features strings are the same for all movies
  // Always divisable by 3
  // movie "feature code" always occures at same place in String?

  public double likenessScore(Movie other) {
    // given that will be in same position
    double matching = 0;
    double divisor = features.length() / 3;
    for (int i = 0; i < this.features.length(); i += 3) {
      String thisFeature = this.features.substring(i, i + 3);
      String otherFeature = other.getFeatures().substring(i, i + 3);
      System.out.printf("%s, %s", thisFeature, otherFeature);
      if (this.features.substring(i, i + 3).equals(other.getFeatures().substring(i, i + 3))) matching++;
    }  
    System.out.println();
    return matching / divisor;
  }

  // assuming toString will return features as we need it for above method?
  @Override
  public String toString() {
    return this.features;
  }

  public String getFeatures() {
    return this.features;
  }
}
