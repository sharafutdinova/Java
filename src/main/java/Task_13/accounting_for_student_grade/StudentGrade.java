package Task_13.accounting_for_student_grade;

import java.util.Objects;

public class StudentGrade<T extends Number> {
    private String name;
    private String subject;
    private T grade;

    public StudentGrade(String name, String subject, T grade) {
        this.name = name;
        this.subject = subject;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public T getGrade() {
        return grade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentGrade<?> that = (StudentGrade<?>) o;
        return Objects.equals(name, that.name) && Objects.equals(subject, that.subject) && Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subject, grade);
    }
}
