package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {


    @Test
    void read_ValidFile_ReturnsSubjectObject() {
        String filePath = "E:\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\Subject.txt";

        Subject subject = InputHandler.read(filePath);

        assertNotNull(subject);
        assertEquals("Software testing", subject.getName());
        assertEquals("CSE333", subject.getCode());
        assertEquals(100, subject.getFullMark());
        assertEquals(6, subject.getStudents().size());
    }

//    @Test
//    void read_EmptyFile_ReturnsNull() {
//        String filePath = "test_files/empty_file.txt";
//
//        Subject subject = InputHandler.read(filePath);
//
//        assertNull(subject);
//    }

//    @Test
//    void read_InvalidSubjectData_ReturnsNull() {
//        String filePath = "test_files/invalid_subject_data.txt";
//
//        Subject subject = InputHandler.read(filePath);
//
//        assertNull(subject);
//    }

//    @Test
//    void read_InvalidStudentData_ReturnsSubjectWithoutInvalidStudents() {
//        String filePath = "test_files/invalid_student_data.txt";
//
//        Subject subject = InputHandler.read(filePath);
//
//        assertNotNull(subject);
//        assertEquals(2, subject.getStudents().size());
//    }

//    @Test
//    void read_InvalidFilePath_ReturnsNull() {
//        String invalidFilePath = "non_existent_file.txt";
//
//        Subject subject = InputHandler.read(invalidFilePath);
//
//        assertNull(subject);
//    }


}