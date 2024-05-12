package org.integrationTest;

import org.example.*;
import org.example.Subject;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SubjectValidatorIntegration {
    // check all is correct
    @Test
    void testAllisCorrect() {

        Subject subject1 = new Subject("Software Testing", "CSE333s", 100);
        String expected = "";
        String actual = SubjectValidator.checkSubjectData(subject1);
        assertEquals(expected, actual);
    }

    // check that an error occurs when subject code is too short
    @Test
    void testSubjectCodeShort() {

        Subject subject2 = new Subject("Software Testing", "CSE33", 100);
        String expected = SubjectValidator.SUBJECT_CODE_INVALID_LENGTH;
        String actual = SubjectValidator.checkSubjectData(subject2);
        assertEquals(expected, actual);
    }

    // check that an error occurs when subject name starts with space
    @Test
    void testSubjectNameSpace() {

        Subject subject3 = new Subject(" Networks", "CSE336", 100);
        String expected = SubjectValidator.SUBJECT_NAME_SPACE;
        String actual = SubjectValidator.checkSubjectData(subject3);
        assertEquals(expected, actual);
    }

    // check that an error occurs when subject name is invalid/has special
    // charcaters

    @Test
    void testSubjectNameInvalid() {

        Subject subject4 = new Subject("Network$", "CSE336", 100);
        String expected = SubjectValidator.SUBJECT_NAME_INVALID;
        String actual = SubjectValidator.checkSubjectData(subject4);
        assertEquals(expected, actual);
    }

    // check that an error occurs when subject max degree isn't 100
    @Test
    void testSubjectMaxDegreeInvalid() {

        Subject subject5 = new Subject("Networks", "CSE336", 90);
        String expected = SubjectValidator.ERROR_MAX_DEGREE;
        String actual = SubjectValidator.checkSubjectData(subject5);
        assertEquals(expected, actual);
    }

    // check that an error occurs when subject code ends with something other than
    // 's' or number

    @Test
    void testSubjectCodeInvalidEnd() {

        Subject subject6 = new Subject("Software Testing", "CSE336#", 100);
        String expected = SubjectValidator.SUBJECT_CODE_END;
        String actual = SubjectValidator.checkSubjectData(subject6);
        assertEquals(expected, actual);
    }

    @Test
    void testSubjectDataMultipleErrors1() {
        // Test for invalid subject data (multiple errors)
        Subject subject7 = new Subject("Software Testing", "CS4333s", 90);
        String expected = SubjectValidator.SUBJECT_CODE_HAS_NUMBERS
                + SubjectValidator.ERROR_MAX_DEGREE;
        String actual = SubjectValidator.checkSubjectData(subject7);
        assertEquals(expected, actual);
    }

    @Test
    void testSubjectDataMultipleErrors2() {
        // Test for invalid subject data (multiple errors)
        Subject subject7 = new Subject("Software Te$sting", "CSE4333s", 150);
        String expected = SubjectValidator.SUBJECT_CODE_INVALID_LENGTH + SubjectValidator.SUBJECT_NAME_INVALID
                + SubjectValidator.ERROR_MAX_DEGREE;
        String actual = SubjectValidator.checkSubjectData(subject7);
        assertEquals(expected, actual);
    }

}