package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class StudentValidatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testCheckStudentName() {
        // Test for valid student name
        Student student1 = new Student("ali", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkStudentName(student1));

        // Test for student name starting with a space
        Student student2 = new Student(" ali yasser", "12345678", 10, 10, 20, 55);
        assertEquals(StudentValidator.STUDENT_NAME_SPACE, StudentValidator.checkStudentName(student2));

        // Test for student name with invalid characters
        Student student3 = new Student("alik4k4", "12345678", 10, 10, 20, 55);
        assertEquals(StudentValidator.STUDENT_NAME_INVALID, StudentValidator.checkStudentName(student3));
    }

    @Test
    void testCheckStudentNumber() {
        // Test for valid student number
        Student student1 = new Student("ali", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkStudentNumber(student1));


        // Test for student number not ending with an alphabet/digit
        Student student3 = new Student("ali", "1234567&", 10, 10, 20, 55);
        assertEquals(StudentValidator.STUDENT_NUMBER_END, StudentValidator.checkStudentNumber(student3));

        // Test for invalid student number length
        Student student4 = new Student("ali", "1234567", 10, 10, 20, 55);
        assertEquals(StudentValidator.STUDENT_NUMBER_INVALID_LENGTH, StudentValidator.checkStudentNumber(student4));
    }

    @Test
    void testCheckActivities() {
        // Test for valid activities mark
        Student student1 = new Student("noha", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkActivities(student1));

        // Test for activities mark exceeding the limit
        Student student2 = new Student("noha", "12345679", 11, 10, 20, 55);
        assertEquals(StudentValidator.ERROR_ACTIVITES_MARK, StudentValidator.checkActivities(student2));

        // Test for negative activities mark
        Student student3 = new Student("noha", "12345670", -1, 10, 20, 55);
        assertEquals(StudentValidator.ERROR_ACTIVITES_MARK, StudentValidator.checkActivities(student3));
    }

    @Test
    void testCheckOral() {
        // Test for valid oral/practical mark
        Student student1 = new Student("shebl", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkOral(student1));

        // Test for oral/practical mark exceeding the limit
        Student student2 = new Student("shebl", "12345679", 10, 11, 20, 55);
        assertEquals(StudentValidator.ERROR_ORAL_MARK, StudentValidator.checkOral(student2));

        // Test for negative oral/practical mark
        Student student3 = new Student("shebl", "12345670", 10, -1, 20, 55);
        assertEquals(StudentValidator.ERROR_ORAL_MARK, StudentValidator.checkOral(student3));
    }

    @Test
    void testCheckMidterm() {
        // Test for valid midterm mark
        Student student1 = new Student("donia", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkMidterm(student1));

        // Test for midterm mark exceeding the limit
        Student student2 = new Student("donia", "12345679", 10, 10, 21, 55);
        assertEquals(StudentValidator.ERROR_MIDTERM_MARK, StudentValidator.checkMidterm(student2));

        // Test for negative midterm mark
        Student student3 = new Student("donia", "12345670", 10, 10, -1, 55);
        assertEquals(StudentValidator.ERROR_MIDTERM_MARK, StudentValidator.checkMidterm(student3));
    }

    @Test
    void testCheckFinal() {
        // Test for valid final exam mark
        Student student1 = new Student("rezk", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkFinal(student1));

        // Test for final exam mark exceeding the limit
        Student student2 = new Student("rezk", "12345679", 10, 10, 20, 61);
        assertEquals(StudentValidator.ERROR_FINAL_MARK, StudentValidator.checkFinal(student2));

        // Test for negative final exam mark
        Student student3 = new Student("rezk", "12345670", 10, 10, 20, -1);
        assertEquals(StudentValidator.ERROR_FINAL_MARK, StudentValidator.checkFinal(student3));
    }

    @Test
    void testCheckStudentData() {
        // Test for valid student data
        Student student1 = new Student("carol", "12345678", 10, 10, 20, 55);
        assertEquals("", StudentValidator.checkStudentData(student1));

        // Test for invalid student data (multiple errors)
        Student student2 = new Student("carol123", "1234567&", 11, -1, 21, 61);
        assertEquals(StudentValidator.STUDENT_NAME_INVALID +
                        StudentValidator.STUDENT_NUMBER_END +
                        StudentValidator.ERROR_ACTIVITES_MARK +
                        StudentValidator.ERROR_FINAL_MARK +
                        StudentValidator.ERROR_ORAL_MARK +
                        StudentValidator.ERROR_MIDTERM_MARK
                        ,
                StudentValidator.checkStudentData(student2));
    }
}