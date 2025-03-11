import java.util.Arrays;

public class ExamAnalysis {
  protected String[] nicknames;
  protected boolean[][] answered;

  public int getDifficulty(int k) {
    boolean[] question = answered[k];
    double temp = 0;
    for (int i = 0; i < question.length; i++) {
      if (!question[i])
        temp++;
    }
    return (int) Math.round(temp / question.length);
  }

  /*
   * So nicknames[k] is a "unit" (ie Appaloosa, Twister, etc)
   * The kth element in the returned array has the nickname nicknames[k] and
   * difficulty computed by above method
   *
   * We must:
   * Create and return a an array of ExamQuestion objects
   * The array will be the same size as this.nicknames
   * the k-th element has name and difficulty (assuming these are paramaters for
   * making ExamQuestion)
   */
  public ExamQuestion[] makeQuestionsList() {
    ExamQuestion[] questions = new ExamQuestion[this.nicknames.length];
    for (int i = 0; i < this.nicknames.length; i++) {
      questions[i] = new ExamQuestion(this.nicknames[i], getDifficulty(i));
    }
    return questions;
  }

  // Mr. Schmidt imma do merge sort for funzies if thats ok.
  // If you need me to also implement selection sort I can
  // do that for ya.

  // Merge Sort
  // Splits Array recursively until literally single element
  // Base case: 1 element in array?
  // Then sort back?
  // I know I need to use 2 pointer approach for merging larger

  // My compareTo should work as its tech only comparing 2 at a time

  public static void sort(ExamQuestion[] questions) {
    // Base case: single element
    if (questions.length < 2)
      return;

    // Cutting array in half
    int mid = questions.length / 2;

    // Arrays.copyOfRange(arr, from, to) -> copies any [] from index i to j - 1
    ExamQuestion[] left = Arrays.copyOfRange(questions, 0, mid);
    ExamQuestion[] right = Arrays.copyOfRange(questions, mid, questions.length);

    // keep splitting
    sort(left);
    sort(right);

    // Idk how to do without helper method
    merge(questions, left, right);
  }

  public static void merge(ExamQuestion[] arr, ExamQuestion[] left, ExamQuestion[] right) {
    // two pointer approach
    int l = 0, r = 0, p = 0; // l is left, r is right, p is position in array

    while (l < left.length && r < right.length) {
      if (left[l].compareTo(right[r]) == -1) {
        arr[p++] = left[l++];
      } else {
        arr[p++] = right[r++];
      }
    }

    // get remaining elemnts from left and right
    while (l < left.length) {
      arr[p++] = left[l++];
    }
    while (r < right.length) {
      arr[p++] = right[r++];
    }
  }
}
