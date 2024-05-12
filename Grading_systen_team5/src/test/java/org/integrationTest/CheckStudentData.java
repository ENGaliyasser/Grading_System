package org.integrationTest;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Student;
import org.example.StudentValidator;
import org.junit.jupiter.api.Test;

public class CheckStudentData {

    @Test
    void correctStudentData() {
        Student student1 = new Student("ali", "12345678", 10, 10, 20, 55);
        StudentValidator valid = new StudentValidator(student1);
        String expected = "";

        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongName() {

        Student student1 = new Student("ali*ish", "12345678", 10, 10, 20, 55);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.STUDENT_NAME_INVALID;
        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongNumber() {

        Student student1 = new Student("ali", "1234567", 10, 10, 20, 55);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.STUDENT_NUMBER_INVALID_LENGTH;
        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongActivities() {
        Student student1 = new Student("shebl", "12345678", 19, 10, 20, 50);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.ERROR_ACTIVITES_MARK;
        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongOral() {
        Student student1 = new Student("shebl", "12345678", 10, 19, 20, 50);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.ERROR_ORAL_MARK;
        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongMid() {
        Student student1 = new Student("shebl", "12345678", 10, 10, 29, 50);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.ERROR_MIDTERM_MARK;
        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongFinal() {
        Student student1 = new Student("shebl", "12345678", 10, 10, 20, 70);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.ERROR_FINAL_MARK;
        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }

    @Test
    void wrongEveryTHING() {
        Student student1 = new Student(" noha", "12345f78", 15, 13, 25, 70);
        StudentValidator valid = new StudentValidator(student1);
        String expected = StudentValidator.STUDENT_NAME_SPACE + StudentValidator.STUDENT_NUMBER_CONTAIN
                + StudentValidator.ERROR_ACTIVITES_MARK + StudentValidator.ERROR_FINAL_MARK +
                StudentValidator.ERROR_ORAL_MARK + StudentValidator.ERROR_MIDTERM_MARK;

        String actual = valid.checkStudentData();

        assertEquals(expected, actual);
    }
}
