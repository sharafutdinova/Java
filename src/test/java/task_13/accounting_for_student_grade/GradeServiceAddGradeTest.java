package task_13.accounting_for_student_grade;

import Task_13.accounting_for_student_grade.InvalidGradeException;
import Task_13.accounting_for_student_grade.StudentGrade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceAddGradeTest extends GradeServiceTest<Number> {
    /**
     * Проверки
     * Валидные оценки 0, 10.0, 100
     * Невалидные оценки -1, -10
     * Добавление в пустой список и непустой
     */
    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    public void userCanAddValidGradeToEmptyList(int grade) throws InvalidGradeException {
        StudentGrade<Number> studentGrade_expected = new StudentGrade<>("Alsu", "Math", grade);
        service.addGrade(new StudentGrade<>("Alsu", "Math", grade));
        StudentGrade<Number> studentGrade_actual = service.getGradeList().getFirst();

        assertEquals(studentGrade_expected, studentGrade_actual);
        assertEquals(1, service.getGradeList().size());
        assertTrue(isStudentsEqual(studentGrade_expected, studentGrade_actual));
    }

    @Test
    public void userCanAddValidGradeToNotEmptyList() throws InvalidGradeException {
        StudentGrade<Number> studentGrade_1_expected = new StudentGrade<>("Alsu", "Math", 10.0);
        service.addGrade(new StudentGrade<>("Alsu", "Math", 10.0));
        StudentGrade<Number> studentGrade_2_expected = new StudentGrade<>("Anna", "Bio", 7);
        service.addGrade(new StudentGrade<>("Anna", "Bio", 7));

        assertEquals(2, service.getGradeList().size());
        StudentGrade<Number> studentGrade_1_actual = service.getGradeList().getFirst();
        StudentGrade<Number> studentGrade_2_actual = service.getGradeList().getLast();
        assertEquals(studentGrade_1_expected, studentGrade_1_actual);
        assertEquals(studentGrade_2_expected, studentGrade_2_actual);
        assertTrue(isStudentsEqual(studentGrade_1_expected, studentGrade_1_actual));
        assertTrue(isStudentsEqual(studentGrade_2_expected, studentGrade_2_actual));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    public void userCannotAddInvalidGradeToEmptyList(int grade) {
        StudentGrade<Number> studentGrade_expected = new StudentGrade<>("Alsu", "Math", grade);
        assertThrows(InvalidGradeException.class, () -> service.addGrade(studentGrade_expected), "При попытке добавления StudentGrade с негативной оценкой не было выброшено исключение  InvalidGradeException");
        assertEquals(0, service.getGradeList().size());
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    public void userCannotAddInvalidGradeToNotEmptyList(int grade) throws InvalidGradeException {
        service.addGrade(new StudentGrade<>("Alsu", "Math", 10));
        StudentGrade<Number> studentGrade_expected = new StudentGrade<>("Alsu", "Math", grade);
        assertThrows(InvalidGradeException.class, () -> service.addGrade(studentGrade_expected), "При попытке добавления StudentGrade с негативной оценкой не было выброшено исключение  InvalidGradeException");
        assertEquals(1, service.getGradeList().size());
    }

    @Test
    public void userCanAddValidGradesFromTwoThreads() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    service.addGrade(new StudentGrade<>("Student from t1 " + i, "Math", i));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    service.addGrade(new StudentGrade<>("Student from t2 " + i, "Bio", i));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        assertEquals(20, service.getGradeList().size());
    }
}
