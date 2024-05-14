package org.WhiteBoxTest;

import org.example.SubjectValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConditionCoverageTest {

    // Test for SUBJECT_CODE_INVALID_LENGTH condition when subject code length is 6
    @Test
    void test1() {
        boolean expected = false;
        boolean actual = SubjectValidator.checkSubjectCode("CSE012").equals(SubjectValidator.SUBJECT_CODE_INVALID_LENGTH);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_INVALID_LENGTH condition when subject code length is 7
    @Test
    void test2() {
        boolean expected = false;
        boolean actual = SubjectValidator.checkSubjectCode("CSE289s").equals(SubjectValidator.SUBJECT_CODE_INVALID_LENGTH);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_INVALID_LENGTH condition when subject code length is 5
    @Test
    void test3() {
        boolean expected = true;
        boolean actual = SubjectValidator.checkSubjectCode("CSE33").equals(SubjectValidator.SUBJECT_CODE_INVALID_LENGTH);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_HAS_NUMBERS condition when subject code contains numbers
    @Test
    void test4() {
        boolean expected = false;
        boolean actual = SubjectValidator.checkSubjectCode("CSE456").equals(SubjectValidator.SUBJECT_CODE_HAS_NUMBERS);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_HAS_NUMBERS condition when subject code starts with a number
    @Test
    void test5() {
        boolean expected = true;
        boolean actual = SubjectValidator.checkSubjectCode("1CS345").equals(SubjectValidator.SUBJECT_CODE_HAS_NUMBERS);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_HAS_LETTERS condition when subject code contains both letters and numbers
    @Test
    void test6() {
        boolean expected = false;
        boolean actual = SubjectValidator.checkSubjectCode("CSE123").equals(SubjectValidator.SUBJECT_CODE_HAS_LETTERS);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_HAS_LETTERS condition when subject code contains letters only
    @Test
    void test7() {
        boolean expected = true;
        boolean actual = SubjectValidator.checkSubjectCode("CSEabc").equals(SubjectValidator.SUBJECT_CODE_HAS_LETTERS);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_END condition when subject code does not end with 's'
    @Test
    void test8() {
        boolean expected = false;
        boolean actual = SubjectValidator.checkSubjectCode("CSE123").equals(SubjectValidator.SUBJECT_CODE_END);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_END condition when subject code ends with 's'
    @Test
    void test9() {
        boolean expected = false;
        boolean actual = SubjectValidator.checkSubjectCode("CSE123s").equals(SubjectValidator.SUBJECT_CODE_END);
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_CODE_END condition when subject code ends with an alphabet character
    @Test
    void test10() {
        boolean expected = true;
        boolean actual = SubjectValidator.checkSubjectCode("CSE123a").equals(SubjectValidator.SUBJECT_CODE_END);
        assertEquals(expected, actual);
    }

    // Test for STRING_EMPTY condition when subject name is empty
    @Test
    void test11() {
        String expected = SubjectValidator.STRING_EMPTY;
        String actual = SubjectValidator.checkSubjectName("");
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_NAME_SPACE condition when subject name starts with a space
    @Test
    void test12() {
        String expected = SubjectValidator.SUBJECT_NAME_SPACE;
        String actual = SubjectValidator.checkSubjectName(" Software Testing");
        assertEquals(expected, actual);
    }

    // Test for SUBJECT_NAME_INVALID condition when subject name contains non-alphabetic characters
    @Test
    void test13() {
        String expected = SubjectValidator.SUBJECT_NAME_INVALID;
        String actual = SubjectValidator.checkSubjectName("Software_Testing");
        assertEquals(expected, actual);
    }

    // Test for no error condition when subject name is valid
    @Test
    void test14() {
        String expected = "";
        String actual = SubjectValidator.checkSubjectName("Software Testing");
        assertEquals(expected, actual);
    }
}