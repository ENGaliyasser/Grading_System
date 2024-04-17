package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class SubjectTest {
    private Subject subjectSingleInputCons;
    private Subject subjectMultiInputCons;
    private Subject forTestSetMethods;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    void init_student() {
        String studentString = "Software testing,CSE333,100";
        subjectSingleInputCons = new Subject(studentString);
        String nameString = "Software testing", codeString = "CSE333";
        int fullmark = 100;
        subjectMultiInputCons = new Subject(nameString, codeString, fullmark);
        forTestSetMethods = new Subject(studentString);
    }

    @Test
    void SubjectConstructorWithSingleInput() {
        /*
         * testing constructor is working by checking if its null or not,checking the
         * functionality with checking the getters in other cases
         */
        assertNotNull(subjectSingleInputCons, "subject obj should  not be null");

    }

    @Test
    void SubjectConstructorWithMultInput() {
        /*
         * testing constructor is working by checking if its null or not,checking the
         * functionality with checking the getters in other cases
         */
        assertNotNull(subjectMultiInputCons, "subject obj should  not be null");

    }

    @Test
    void test_getNameWithSingleInput() {
        assertEquals("Software testing", subjectSingleInputCons.getName());
    }

    @Test
    void test_getCodeWithSingleInput() {
        assertEquals("CSE333", subjectSingleInputCons.getCode());
    }

    @Test
    void test_getFullMarkWithSingleInput() {
        assertEquals(100, subjectSingleInputCons.getFullMark());
    }

    @Test
    void test_getStudentsWithSingleInputIsInitialized() {
        assertNotNull(subjectSingleInputCons.getStudents());
    }

    @Test
    void test_getStudentsWithSingleInputIsEmpty() {
        assertEquals(0, subjectSingleInputCons.getStudents().size());
    }

    @Test
    void test_getNameWithMultiInput() {
        assertEquals("Software testing", subjectMultiInputCons.getName());
    }

    @Test
    void test_getCodeWithMultiInput() {
        assertEquals("CSE333", subjectMultiInputCons.getCode());
    }

    @Test
    void test_getFullMarkWithMultiInput() {
        assertEquals(100, subjectMultiInputCons.getFullMark());
    }

    @Test
    void test_getStudentsWithMultiInputIsInitialized() {
        assertNotNull(subjectMultiInputCons.getStudents());
    }

    @Test
    void test_getStudentsWithMultiInputIsEmpty() {
        assertEquals(0, subjectMultiInputCons.getStudents().size());
    }

    @Test
    void test_setName() {
        forTestSetMethods.setName("just testing");
        assertEquals("just testing", forTestSetMethods.getName());
    }

    @Test
    void test_setCode() {
        forTestSetMethods.setCode("notCSE333");
        assertEquals("notCSE333", forTestSetMethods.getCode());
    }

    @Test
    void test_setFullMark() {
        forTestSetMethods.setFullMark(120);
        assertEquals(120, forTestSetMethods.getFullMark());
    }

    @Test
    void test_setStudent() {
        Student s1 = new Student("aliiiii,12345678,10,10,20,55");
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        forTestSetMethods.setStudents(students);
        assertEquals(1, forTestSetMethods.getStudents().size());
    }

}