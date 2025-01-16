public class APExam implements Exam{
    private String subject;
    private int grade;

    public APExam(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    @Override
    public String getSubject() {
        return this.subject;
    }

    @Override
    public int getGrade() {
        return this.grade;
    }
}
