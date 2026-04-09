package task_13.accounting_for_student_grade;

import Task_13.accounting_for_student_grade.InvalidGradeException;
import Task_13.accounting_for_student_grade.StudentGrade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeServiceGetGradeAverageTest extends GradeServiceTest<Number> {
    /**
     * Тесты для метода вычисления среднего
     * Среднее для предмета где 1 оценка для предмета в списке где 1 предмет
     * Среднее для предмета где 1 оценка для предмета в списке где несколько предметов
     * Среднее для предмета где несколько одинаковых оценок в списке где несколько предметов
     * Среднее для предмета где несколько разных оценок в списке где несколько предметов
     * Среднее для предмета где нет оценок
     * Среднее для предмета "" и null -> IllegalArgumentException
     */

    @Test
    public void userCanGetGradeAverageForSubjectWithOneGradeInList() throws InvalidGradeException {
        String subject = "math";
        Double expectedGrade = 10.0;
        service.addGrade(new StudentGrade<>("Alsu", subject, expectedGrade));
        Double actualAverage = service.getAverageGrade(subject);
        assertEquals(expectedGrade, actualAverage);
    }

    @Test
    public void userCanGetGradeAverageForSubjectWithSeveralGradeInList() throws InvalidGradeException {
        String subject = "math";
        Double expectedGrade = 10.0;
        service.addGrade(new StudentGrade<>("Alsu", subject, expectedGrade));
        service.addGrade(new StudentGrade<>("Alsu", "Bio", 4));
        service.addGrade(new StudentGrade<>("Alsu", "Geo", 6));
        Double actualAverage = service.getAverageGrade(subject);
        assertEquals(expectedGrade, actualAverage);
    }

    @Test
    public void userCanGetGradeAverageForSubjectWithSeveralSameGradesInList() throws InvalidGradeException {
        String subject = "bio";
        Double expectedGrade = 10.0;
        service.addGrade(new StudentGrade<>("Alsu", subject, expectedGrade));
        service.addGrade(new StudentGrade<>("Alsu", subject, expectedGrade));
        service.addGrade(new StudentGrade<>("Lena", subject, expectedGrade));
        service.addGrade(new StudentGrade<>("Alsu", "Geo", 6));
        service.addGrade(new StudentGrade<>("Masha", "Math", 13));
        Double actualAverage = service.getAverageGrade(subject);
        assertEquals(expectedGrade, actualAverage);
    }

    @Test
    public void userCanGetGradeAverageForSubjectWithSeveralDifferentGradesInList() throws InvalidGradeException {
        String subject = "bio";
        service.addGrade(new StudentGrade<>("Alsu", subject, 5));
        service.addGrade(new StudentGrade<>("Alsu", subject, 7.5));
        service.addGrade(new StudentGrade<>("Alsu", "Geo", 6.0));
        service.addGrade(new StudentGrade<>("Masha", "Math", 13.4));
        service.addGrade(new StudentGrade<>("Lena", subject, 9.6));
        Double actualAverage = service.getAverageGrade(subject);
        Double expectedGrade = getAverageForSubject(service, subject);
        assertEquals(expectedGrade, actualAverage);
    }

    @Test
    public void userCanGetGradeAverageForSubjectWithoutGradesInList() throws InvalidGradeException {
        String subject = "bio";
        service.addGrade(new StudentGrade<Number>("Lena", "Math", 10));
        service.addGrade(new StudentGrade<>("Alsu", "Geo", 6));
        service.addGrade(new StudentGrade<>("Masha", "Math", 13));
        Double actualAverage = service.getAverageGrade(subject);
        assertEquals(0, actualAverage);
    }

    @Test
    public void userCannotGetGradeAverageForNullSubject() {
        String subject = null;
        assertThrows(IllegalArgumentException.class, () -> service.getAverageGrade(subject),
                "При вычислении средней оценки для null предмета не было исключения IllegalArgumentException");
    }

    @Test
    public void userCannotGetGradeAverageForEmptySubject() {
        String subject = "";
        assertThrows(IllegalArgumentException.class, () -> service.getAverageGrade(subject),
                "При вычислении средней оценки для пустого предмета не было исключения IllegalArgumentException");
    }
}
