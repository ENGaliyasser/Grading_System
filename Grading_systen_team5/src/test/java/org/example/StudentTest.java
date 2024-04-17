package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class StudentTest {
    private Student studentSingleInputCons;
    private Student studentMultInputCons;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    void init_student() {
        String studentString = "aliiiii,12345678,10,10,20,55";
        studentSingleInputCons = new Student(studentString);
        String nameString = "shebl", numberString = "333";
        int activities = 10, oral = 7, mid = 16, finalmark = 60;
        studentMultInputCons = new Student(nameString, numberString, activities, oral, mid,
                finalmark);

    }

    @Test
    void StudentConstructorWithSingleInput() {
        /*
         * testing constructor is working by checking if its null or not,checking the
         * functionality with checking the getters in other cases
         */
        assertNotNull(studentSingleInputCons, "student obj should  not be null");

    }

    @Test
    void StudentConstructorWithMultInput() {
        /*
         * testing constructor is working by checking if its null or not,checking the
         * functionality with checking the getters in other cases
         */
        assertNotNull(studentMultInputCons, "student obj should  not be null");

    }

    @Test
    void nameWithSingleInput() {
        assertEquals("aliiiii", studentSingleInputCons.getName());
    }

    @Test
    void numberWithSingleInput() {
        assertEquals("12345678", studentSingleInputCons.getStudentNumber());
    }

    @Test
    void activitiesWithSingleInput() {
        assertEquals(10, studentSingleInputCons.getActivitiesMark());
    }

    @Test
    void oralWithSingleInput() {
        assertEquals(10, studentSingleInputCons.getOral_practicalMark());
    }

    @Test
    void midtermWithSingleInput() {
        assertEquals(20, studentSingleInputCons.getMidtermMark());
    }

    @Test
    void finalWithSingleInput() {
        assertEquals(55, studentSingleInputCons.getFinalMark());
    }

    @Test
    void sumWithSingleInput() {
        assertEquals(95, studentSingleInputCons.getSum());
    }

    @Test
    void nameWithMultInput() {
        assertEquals("shebl", studentMultInputCons.getName());
    }

    @Test
    void numberWithMultInput() {
        assertEquals("333", studentMultInputCons.getStudentNumber());
    }

    @Test
    void activitiesWithMultInput() {
        assertEquals(10, studentMultInputCons.getActivitiesMark());
    }

    @Test
    void oralWithMultInput() {
        assertEquals(7, studentMultInputCons.getOral_practicalMark());
    }

    @Test
    void midtermWithMultInput() {
        assertEquals(16, studentMultInputCons.getMidtermMark());
    }

    @Test
    void finalWithMultInput() {
        assertEquals(60, studentMultInputCons.getFinalMark());
    }

    @Test
    void sumWithMultInput() {
        assertEquals(93, studentMultInputCons.getSum());
    }

    @Test
    void test_setSum() {
        Student forSumTest = new Student("aliiiii,12345678,10,10,20,55");

        forSumTest.setSum(70);
        assertEquals(70, forSumTest.getSum());

    }

    @Test
    void test_calculateGrade() {
        assertEquals("A", studentSingleInputCons.calculateGrade());
    }

    @Test
    void test_calculateGPA() {
        assertEquals(4, studentSingleInputCons.calculateGPA());
    }

    @Test
    void test_calculateGradeEdgeCases1() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(100);
        assertEquals("A+", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases2() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");

        forCalculation.setSum(97);
        assertEquals("A+", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases3() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");

        forCalculation.setSum(93);
        assertEquals("A", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases4() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(90);
        assertEquals("A-", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases5() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(84);
        assertEquals("B+", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases6() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(80);
        assertEquals("B", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases7() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(76);
        assertEquals("B-", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases8() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(73);
        assertEquals("C+", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases9() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(70);
        assertEquals("C", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases10() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(67);
        assertEquals("C-", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases11() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(64);
        assertEquals("D+", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases12() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(60);
        assertEquals("D", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases13() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(50);
        assertEquals("F", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases14() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(0);
        assertEquals("F", forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGradeEdgeCases15() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(-14);
        assertEquals(Student.ERROR_SUM, forCalculation.calculateGrade());
    }

    @Test
    void test_calculateGPAEdgeCases1() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(100);
        assertEquals(4, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases2() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(93);
        assertEquals(4, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases3() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(90);
        assertEquals(3.7, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases4() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(84);
        assertEquals(3.3, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases5() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(80);
        assertEquals(3, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases6() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");

        forCalculation.setSum(76);
        assertEquals(2.7, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases7() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");

        forCalculation.setSum(73);
        assertEquals(2.3, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases8() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(70);
        assertEquals(2, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases9() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(67);
        assertEquals(1.7, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases10() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(64);
        assertEquals(1.3, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases11() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(60);
        assertEquals(1, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases12() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(50);
        assertEquals(0, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases13() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(0);
        assertEquals(0, forCalculation.calculateGPA());
    }

    @Test
    void test_calculateGPAEdgeCases14() {
        Student forCalculation = new Student("aliiiii,12345678,10,10,20,55");
        forCalculation.setSum(-14);
        assertEquals(Student.ERROR_GPA, forCalculation.calculateGPA());
    }

    // @Test
    // void testStudentConstructorWithString() {
    // // Test for constructor that takes a string

    // assertEquals("aliiiii", studentStringsCons.getName());
    // assertEquals("12345678", studentStringsCons.getStudentNumber());
    // assertEquals(10, studentStringsCons.getActivitiesMark());
    // assertEquals(10, studentStringsCons.getOral_practicalMark());
    // assertEquals(20, studentStringsCons.getMidtermMark());
    // assertEquals(55, studentStringsCons.getFinalMark());
    // assertEquals(95, studentStringsCons.getSum()); // Assuming sum calculation is
    // correct
    // }
    // @Test
    // void testCalculateGPA() {
    // assertEquals(4.0, Student.calculateGPA(97));
    // assertEquals(4.0, Student.calculateGPA(100));
    // assertEquals(3.7, Student.calculateGPA(92));
    // assertEquals(3.3, Student.calculateGPA(87));
    // assertEquals(3.0, Student.calculateGPA(82));
    // assertEquals(2.7, Student.calculateGPA(78));
    // assertEquals(2.3, Student.calculateGPA(75));
    // assertEquals(2.0, Student.calculateGPA(70));
    // assertEquals(1.7, Student.calculateGPA(68));
    // assertEquals(1.3, Student.calculateGPA(65));
    // assertEquals(1.0, Student.calculateGPA(62));
    // assertEquals(0.0, Student.calculateGPA(50));
    // assertEquals(Student.ERROR_GPA, Student.calculateGPA(-10));
    // }

    // @Test
    // void testCalculateGrade() {
    // assertEquals("A+", Student.calculateGrade(97));
    // assertEquals("A+", Student.calculateGrade(100));
    // assertEquals("A", Student.calculateGrade(93));
    // assertEquals("A-", Student.calculateGrade(90));
    // assertEquals("B+", Student.calculateGrade(86));
    // assertEquals("B", Student.calculateGrade(82));
    // assertEquals("B-", Student.calculateGrade(78));
    // assertEquals("C+", Student.calculateGrade(75));
    // assertEquals("C", Student.calculateGrade(70));
    // assertEquals("C-", Student.calculateGrade(68));
    // assertEquals("D+", Student.calculateGrade(65));
    // assertEquals("D", Student.calculateGrade(62));
    // assertEquals("F", Student.calculateGrade(50));
    // assertEquals(Student.ERROR_SUM, Student.calculateGrade(-10));
    // }

    // @Test
    // void testCalculateGPAWithSum() {
    // assertEquals(4.0, Student.calculateGPA(97));
    // assertEquals(4.0, Student.calculateGPA(100));
    // assertEquals(3.7, Student.calculateGPA(92));
    // assertEquals(3.3, Student.calculateGPA(87));
    // assertEquals(3.0, Student.calculateGPA(82));
    // assertEquals(2.7, Student.calculateGPA(78));
    // assertEquals(2.3, Student.calculateGPA(75));
    // assertEquals(2.0, Student.calculateGPA(70));
    // assertEquals(1.7, Student.calculateGPA(68));
    // assertEquals(1.3, Student.calculateGPA(65));
    // assertEquals(1.0, Student.calculateGPA(62));
    // assertEquals(0.0, Student.calculateGPA(50));
    // assertEquals(Student.ERROR_GPA, Student.calculateGPA(-10));
    // }

    // @Test
    // void testCalculateGradeWithSum() {
    // assertEquals("A+", Student.calculateGrade(97));
    // assertEquals("A+", Student.calculateGrade(100));
    // assertEquals("A", Student.calculateGrade(93));
    // assertEquals("A-", Student.calculateGrade(90));
    // assertEquals("B+", Student.calculateGrade(86));
    // assertEquals("B", Student.calculateGrade(82));
    // assertEquals("B-", Student.calculateGrade(78));
    // assertEquals("C+", Student.calculateGrade(75));
    // assertEquals("C", Student.calculateGrade(70));
    // assertEquals("C-", Student.calculateGrade(68));
    // assertEquals("D+", Student.calculateGrade(65));
    // assertEquals("D", Student.calculateGrade(62));
    // assertEquals("F", Student.calculateGrade(50));
    // assertEquals(Student.ERROR_SUM, Student.calculateGrade(-10));
    // }

}