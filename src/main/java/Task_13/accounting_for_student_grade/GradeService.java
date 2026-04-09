package Task_13.accounting_for_student_grade;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeService<T extends Number> {
    private List<StudentGrade<T>> gradeList = new LinkedList<>();

    public synchronized void addGrade(StudentGrade<T> studentGrade) throws InvalidGradeException {
        if (studentGrade.getGrade().doubleValue() >= 0) gradeList.add(studentGrade);
        else throw new InvalidGradeException("Оценка не может быть отрицательной");
    }

    public Double getAverageGrade(String subject) {
        if (subject == null|| subject.isEmpty())
            throw new IllegalArgumentException("Subject не может быть null или пустым");
        return gradeList.stream().filter(grade -> grade.getSubject().
                equals(subject)).map(StudentGrade::getGrade).collect(Collectors.averagingDouble(Number::doubleValue));
    }

    public List<StudentGrade<T>> getGradeList() {
        return List.copyOf(gradeList);
    }
}
