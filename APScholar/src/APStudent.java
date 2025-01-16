import java.util.ArrayList;
import java.util.List;
public class APStudent {
    private List<Exam> exams;

    public APStudent() {
        exams = new ArrayList<>();
    }

    public void add(Exam e) {
        exams.add(e);
    }

    public int getAwardLevel() {
        int passedExams = 0;
        double totalScore = 0;
        for (Exam e : exams) {
            totalScore += e.getGrade();
            if (e.getGrade() >= 3) {
                passedExams += 1;
            }
        }
        double averageScore = totalScore / exams.size();

        if (passedExams == 5 && averageScore >= 3.25) {
            return 3;
        }
        if (passedExams == 4 && averageScore >= 3.25) {
            return 2;
        }
        if (passedExams == 3) {
            return 1;
        }
        return 0;
    }
}
