package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BranchCoverageTest {

    @Test
    void test1() {
        double expected = 4.0;
        double actual = Student.calculateGPA(96);
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        double expected = 3.7;
        double actual = Student.calculateGPA(91);
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        double expected = 3.3;
        double actual = Student.calculateGPA(86);
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        double expected = 3.0;
        double actual = Student.calculateGPA(82);
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        double expected = 2.7;
        double actual = Student.calculateGPA(77);
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        double expected = 2.3;
        double actual = Student.calculateGPA(75);
        assertEquals(expected, actual);
    }

    @Test
    void test7() {
        double expected = 2.0;
        double actual = Student.calculateGPA(72);
        assertEquals(expected, actual);
    }

    @Test
    void test8() {
        double expected = 1.7;
        double actual = Student.calculateGPA(69);
        assertEquals(expected, actual);
    }

    @Test
    void test9() {
        double expected = 1.3;
        double actual = Student.calculateGPA(65);
        assertEquals(expected, actual);
    }

    @Test
    void test10() {
        double expected = 1.0;
        double actual = Student.calculateGPA(62);
        assertEquals(expected, actual);
    }

    @Test
    void test11() {
        double expected = 0;
        double actual = Student.calculateGPA(42);
        assertEquals(expected, actual);
    }

    @Test
    void test12() {
        double expected = Student.ERROR_GPA;
        double actual = Student.calculateGPA(-9);
        assertEquals(expected, actual);
    }
}