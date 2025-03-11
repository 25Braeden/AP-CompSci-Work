import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    ExamAnalysis test = new ExamAnalysis();
    test.nicknames = new String[] { "Appaloosa", "Twister", "AP Scholar", "Exam Questions" };
    test.answered = new boolean[][] {
        { true, true, true, false },
        { false, true, true, false },
        { true, false, true, true },
        { false, true, false, false },
        { false, false, true, false }
    };

    ExamQuestion[] questions = test.makeQuestionsList();
    ExamAnalysis.sort(questions);
    System.out.println(Arrays.asList(questions));

  }
}
