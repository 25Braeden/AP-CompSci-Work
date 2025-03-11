public class ExamQuestion implements Comparable<ExamQuestion> {
  protected String nickname;
  protected int difficulty;

  public ExamQuestion(String nickname, int difficulty) {
    this.nickname = nickname;
    this.difficulty = difficulty;
  }

  // Will return -1 if less, 0 if equal, 1 if greater
  @Override
  public int compareTo(ExamQuestion other) {
    if (this.difficulty < other.difficulty)
      return -1;
    else if (this.difficulty == other.difficulty)
      return 0;
    else
      return 1;
  }

  @Override
  public String toString() {
    return String.format("%s: %d", this.nickname, this.difficulty);
  }
}
