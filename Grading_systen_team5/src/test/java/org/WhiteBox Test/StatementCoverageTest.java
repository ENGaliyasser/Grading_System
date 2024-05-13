package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatementCoverageTest {

    // Test case for an empty student name
    @Test
    void test1() {
        Student student = new Student("", "12345678", 10, 8, 15, 50);
        String expected = StudentValidator.STRING_EMPTY;
        String actual = StudentValidator.checkStudentName(student);
        assertEquals(expected, actual);
    }

    // Test case for a student name starting with a space
    @Test
    void test2() {
        Student student = new Student(" Ali", "12345678", 10, 8, 15, 50);
        String expected = StudentValidator.STUDENT_NAME_SPACE;
        String actual = StudentValidator.checkStudentName(student);
        assertEquals(expected, actual);
    }

    // Test case for a student name containing non-alphabetic characters
    @Test
    void test3() {
        Student student = new Student("3abdelrahman", "12345678", 10, 8, 15, 50);
        String expected = StudentValidator.STUDENT_NAME_INVALID;
        String actual = StudentValidator.checkStudentName(student);
        assertEquals(expected, actual);
    }

    // Test case for a valid student name
    @Test
    void test4() {
        Student student = new Student("Youssef", "12345678", 10, 8, 15, 50);
        String expected = "";
        String actual = StudentValidator.checkStudentName(student);
        assertEquals(expected, actual);
    }

    // Test case for a student number containing non-digit characters
    @Test
    void test5() {
        Student student = new Student("Donia", "12345a78", 10, 8, 15, 50);
        String expected = StudentValidator.STUDENT_NUMBER_CONTAIN;
        String actual = StudentValidator.checkStudentNumber(student);
        assertEquals(expected, actual);
    }

    // Test case for a student number not ending with an alphabet/digit
    @Test
    void test6() {
        Student student = new Student("Noha", "1234567&", 10, 8, 15, 50);
        String expected = StudentValidator.STUDENT_NUMBER_END;
        String actual = StudentValidator.checkStudentNumber(student);
        assertEquals(expected, actual);
    }

    // Test case for a student number with invalid length
    @Test
    void test7() {
        Student student = new Student("Carol", "123456789", 10, 8, 15, 50);
        String expected = StudentValidator.STUDENT_NUMBER_INVALID_LENGTH;
        String actual = StudentValidator.checkStudentNumber(student);
        assertEquals(expected, actual);
    }

    // Test case for a valid student number
    @Test
    void test8() {
        Student student = new Student("Ali", "12345678", 10, 8, 15, 50);
        String expected = "";
        String actual = StudentValidator.checkStudentNumber(student);
        assertEquals(expected, actual);
    }
}