package task_13.accounting_for_student_grade;

import Task_13.accounting_for_student_grade.GradeService;
import Task_13.accounting_for_student_grade.StudentGrade;
import org.junit.jupiter.api.BeforeEach;

import java.util.stream.Collectors;

public class GradeServiceTest<T extends Number> {
    GradeService<T> service;

    @BeforeEach
    public void testSetup() {
        this.service = new GradeService<>();
    }

    public double getAverageForSubject(GradeService<Number> service, String subject) {
        return service.getGradeList().stream().filter(grade -> grade.getSubject().
                equals(subject)).map(StudentGrade::getGrade).collect(Collectors.averagingDouble((Number::doubleValue)));
    }

    public boolean isStudentsEqual(StudentGrade<Number> studentGrade_expected, StudentGrade<Number> studentGrade_actual) {
        return studentGrade_expected.getGrade().equals(studentGrade_actual.getGrade())
                && studentGrade_expected.getName().equals(studentGrade_actual.getName())
                && studentGrade_expected.getSubject().equals(studentGrade_actual.getSubject());
    }
}
