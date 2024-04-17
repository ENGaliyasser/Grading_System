package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class SubjectValidatorTest {
    private SubjectValidator validatorEmpty;
    private SubjectValidator validatorInitialized;

    @BeforeEach
    void setUp() {
        String subjectData = "Software Testing,CSE333,100";
        Subject subject = new Subject(subjectData);
        validatorInitialized = new SubjectValidator(subject);
    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    void subjectValidatorObj() {
        validatorEmpty = new SubjectValidator();

    }

    @Test
    void testEmptyConstructor() {
        assertNotNull(validatorEmpty);
    }

    @Test
    void testInitializingConstructor() {
        assertNotNull(validatorInitialized);
    }

    @Test
    void testGetSubjectEmptyConstructor() {
        assertNull(validatorEmpty.getSubject());
    }

    @Test
    void testGetSubjectInitializingConstructor() {
        assertNotNull(validatorInitialized.getSubject());
    }

    @Test
    void testCheckSubjectName1() {

        assertEquals("", validatorInitialized.checkSubjectName());
    }

    @Test
    void testCheckSubjectName2() {
        validatorInitialized.getSubject().setName("testing");
        assertEquals("", validatorInitialized.checkSubjectName());
    }

    @Test
    void testCheckSubjectName3() {
        validatorInitialized.getSubject().setName("     ");
        assertEquals(SubjectValidator.SUBJECT_NAME_SPACE, validatorInitialized.checkSubjectName());
    }

    @Test
    void testCheckSubjectName4() {
        validatorInitialized.getSubject().setName(" testing");
        assertEquals(SubjectValidator.SUBJECT_NAME_SPACE, validatorInitialized.checkSubjectName());
    }

    @Test
    void testCheckSubjectName5() {
        validatorInitialized.getSubject().setName("testing123");
        assertEquals(SubjectValidator.SUBJECT_NAME_INVALID, validatorInitialized.checkSubjectName());
    }

    @Test
    void testCheckSubjectName6() {
        validatorInitialized.getSubject().setName("test#ing$#");
        assertEquals(SubjectValidator.SUBJECT_NAME_INVALID, validatorInitialized.checkSubjectName());
    }

    @Test
    void testCheckSubjectCode1() {

        assertEquals("", validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode2() {
        validatorInitialized.getSubject().setCode("CSE333s");
        assertEquals("", validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode3() {
        validatorInitialized.getSubject().setCode("CS333s");
        assertEquals(SubjectValidator.SUBJECT_CODE_HAS_NUMBERS, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode4() {
        validatorInitialized.getSubject().setCode("CSE33s");
        assertEquals(SubjectValidator.SUBJECT_CODE_HAS_LETTERS, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode5() {
        validatorInitialized.getSubject().setCode("CS33s");
        assertEquals(SubjectValidator.SUBJECT_CODE_INVALID_LENGTH, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode6() {
        validatorInitialized.getSubject().setCode("CSE4333s");
        assertEquals(SubjectValidator.SUBJECT_CODE_INVALID_LENGTH, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode7() {
        validatorInitialized.getSubject().setCode("CSE4333");
        assertEquals(SubjectValidator.SUBJECT_CODE_END, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode8() {
        validatorInitialized.getSubject().setCode("CSE433E");
        assertEquals(SubjectValidator.SUBJECT_CODE_END, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode9() {
        validatorInitialized.getSubject().setCode("CSE433#");
        assertEquals(SubjectValidator.SUBJECT_CODE_END, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode10() {
        validatorInitialized.getSubject().setCode("CSE43@s");
        assertEquals(SubjectValidator.SUBJECT_CODE_HAS_LETTERS, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckSubjectCode11() {
        validatorInitialized.getSubject().setCode("CS@433s");
        assertEquals(SubjectValidator.SUBJECT_CODE_HAS_NUMBERS, validatorInitialized.checkSubjectCode());
    }

    @Test
    void testCheckMaxDegree1() {

        assertEquals("", validatorInitialized.checkMaxDegree());
    }

    @Test
    void testCheckMaxDegree2() {
        validatorInitialized.getSubject().setFullMark(90);
        assertEquals(SubjectValidator.ERROR_MAX_DEGREE, validatorInitialized.checkMaxDegree());
    }

    @Test
    void testCheckMaxDegree3() {
        validatorInitialized.getSubject().setFullMark(120);
        assertEquals(SubjectValidator.ERROR_MAX_DEGREE, validatorInitialized.checkMaxDegree());
    }

}