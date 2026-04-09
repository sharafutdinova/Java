package task_13.accounting_for_student_grade;

import Task_13.accounting_for_student_grade.InvalidGradeException;
import Task_13.accounting_for_student_grade.StudentGrade;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GradeServiceGetGradeTest extends GradeServiceTest<Number> {
    /**
     * Проверки
     * Пустой список
     * Непустой список
     * Изменение списка после получения копии
     */
    @Test
    public void userCanGetEmptyList() {
        List<StudentGrade<Number>> gradeList = service.getGradeList();
        assertEquals(0, gradeList.size());
    }

    @Test
    public void userCanGetNotEmptyList() throws InvalidGradeException {
        StudentGrade<Number> studentGrade_1 = new StudentGrade<>("Alsu", "Geo", 6.0);
        StudentGrade<Number> studentGrade_2 = new StudentGrade<>("Masha", "Math", 13.4);
        service.addGrade(new StudentGrade<>("Alsu", "Geo", 6.0));
        service.addGrade(new StudentGrade<>("Masha", "Math", 13.4));
        List<StudentGrade<Number>> gradeList = service.getGradeList();
        assertEquals(2, gradeList.size());
        assertTrue(gradeList.contains(studentGrade_1));
        assertTrue(gradeList.contains(studentGrade_2));
    }

    @Test
    public void userCanGetCopyOfList() throws InvalidGradeException {
        StudentGrade<Number> studentGrade_1 = new StudentGrade<>("Alsu", "Geo", 6.0);
        service.addGrade(new StudentGrade<>("Alsu", "Geo", 6.0));
        List<StudentGrade<Number>> gradeList = service.getGradeList();
        StudentGrade<Number> studentGrade_2 = new StudentGrade<>("Masha", "Math", 13.4);
        service.addGrade(new StudentGrade<>("Masha", "Math", 13.4));
        assertEquals(1, gradeList.size());
        assertTrue(gradeList.contains(studentGrade_1));
        assertFalse(gradeList.contains(studentGrade_2));
    }


}
