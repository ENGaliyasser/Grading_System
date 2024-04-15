package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCalculateGPA() {
        assertEquals(4.0, Student.calculateGPA(97));
        assertEquals(4.0, Student.calculateGPA(100));
        assertEquals(3.7, Student.calculateGPA(92));
        assertEquals(3.3, Student.calculateGPA(87));
        assertEquals(3.0, Student.calculateGPA(82));
        assertEquals(2.7, Student.calculateGPA(78));
        assertEquals(2.3, Student.calculateGPA(75));
        assertEquals(2.0, Student.calculateGPA(70));
        assertEquals(1.7, Student.calculateGPA(68));
        assertEquals(1.3, Student.calculateGPA(65));
        assertEquals(1.0, Student.calculateGPA(62));
        assertEquals(0.0, Student.calculateGPA(50));
        assertEquals(Student.ERROR_GPA, Student.calculateGPA(-10));
    }

    @Test
    void testCalculateGrade() {
        assertEquals("A+", Student.calculateGrade(97));
        assertEquals("A+", Student.calculateGrade(100));
        assertEquals("A", Student.calculateGrade(93));
        assertEquals("A-", Student.calculateGrade(90));
        assertEquals("B+", Student.calculateGrade(86));
        assertEquals("B", Student.calculateGrade(82));
        assertEquals("B-", Student.calculateGrade(78));
        assertEquals("C+", Student.calculateGrade(75));
        assertEquals("C", Student.calculateGrade(70));
        assertEquals("C-", Student.calculateGrade(68));
        assertEquals("D+", Student.calculateGrade(65));
        assertEquals("D", Student.calculateGrade(62));
        assertEquals("F", Student.calculateGrade(50));
        assertEquals(Student.ERROR_SUM, Student.calculateGrade(-10));
    }

    @Test
    void testCalculateGPAWithSum() {
        assertEquals(4.0, Student.calculateGPA(97));
        assertEquals(4.0, Student.calculateGPA(100));
        assertEquals(3.7, Student.calculateGPA(92));
        assertEquals(3.3, Student.calculateGPA(87));
        assertEquals(3.0, Student.calculateGPA(82));
        assertEquals(2.7, Student.calculateGPA(78));
        assertEquals(2.3, Student.calculateGPA(75));
        assertEquals(2.0, Student.calculateGPA(70));
        assertEquals(1.7, Student.calculateGPA(68));
        assertEquals(1.3, Student.calculateGPA(65));
        assertEquals(1.0, Student.calculateGPA(62));
        assertEquals(0.0, Student.calculateGPA(50));
        assertEquals(Student.ERROR_GPA, Student.calculateGPA(-10));
    }

    @Test
    void testCalculateGradeWithSum() {
        assertEquals("A+", Student.calculateGrade(97));
        assertEquals("A+", Student.calculateGrade(100));
        assertEquals("A", Student.calculateGrade(93));
        assertEquals("A-", Student.calculateGrade(90));
        assertEquals("B+", Student.calculateGrade(86));
        assertEquals("B", Student.calculateGrade(82));
        assertEquals("B-", Student.calculateGrade(78));
        assertEquals("C+", Student.calculateGrade(75));
        assertEquals("C", Student.calculateGrade(70));
        assertEquals("C-", Student.calculateGrade(68));
        assertEquals("D+", Student.calculateGrade(65));
        assertEquals("D", Student.calculateGrade(62));
        assertEquals("F", Student.calculateGrade(50));
        assertEquals(Student.ERROR_SUM, Student.calculateGrade(-10));
    }
    @Test
    void testStudentConstructorWithString() {
        // Test for constructor that takes a string
        String studentString = "aliiiii,12345678,10,10,20,55";
        Student student = new Student(studentString);

        assertEquals("aliiiii", student.getName());
        assertEquals("12345678", student.getStudentNumber());
        assertEquals(10, student.getActivitiesMark());
        assertEquals(10, student.getOral_practicalMark());
        assertEquals(20, student.getMidtermMark());
        assertEquals(55, student.getFinalMark());
        assertEquals(95, student.getSum()); // Assuming sum calculation is correct
    }
}