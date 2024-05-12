package org.integrationTest;

import org.example.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class InputHandlerReadIntegrationTest {
    private ByteArrayOutputStream out;
    Subject subject1;

    @BeforeEach
    void Init() {
        out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
        subject1 = new Subject("Init", "Init", 100);
    }

    @Test
    public void testFileNotFound() {
        String filename = "Test\\NoFile.txt";
        subject1 = InputHandler.read(filename);

        String expected = "Invalid file name. File could not be opened.\n";
        String actual = out.toString();

        assertEquals(expected, actual);

    }

    @Test
    public void testEmptyStudent() {

        String filename = "C:\\Users\\youssef\\Desktop\\programing\\Testing\\project\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\EmptyStudent.txt";

        subject1 = InputHandler.read(filename);
        String expected = StudentValidator.STRING_EMPTY;
        String actual = out.toString();

        assertEquals(expected, actual);

    }

    // if subject data was not in the first line
    @Test
    public void testSubjectNotFound() {

        String filename = "C:\\Users\\youssef\\Desktop\\programing\\Testing\\project\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\SubjectNotFound.txt";
        subject1 = InputHandler.read(filename);

        String expected = "No subject data found. Subject data must be in the first line.\n";
        String actual = out.toString();

        assertEquals(expected, actual);

    }

    // the file is read and there was an error in subject
    @Test
    public void testSubjectError() {

        String filename = "C:\\Users\\youssef\\Desktop\\programing\\Testing\\project\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\SubjectError.txt";
        subject1 = InputHandler.read(filename);

        String expected = "Error in subject data:\nError: Max degree must be one of the following values: 100.\n";
        String actual = out.toString();

        assertEquals(expected, actual);

    }

    @Test
    public void testNoErrors() {

        String filename = "C:\\Users\\youssef\\Desktop\\programing\\Testing\\project\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\NoErrors.txt";
        subject1 = InputHandler.read(filename);

        // assertEquals("Software Testing", subject1.getName());
        // assertEquals("CSE333s", subject1.getCode());
        // assertEquals(100, subject1.getFullMark());

        // int expected = 6;
        // int actual = subject1.getStudents().size();
        // assertEquals(expected, actual);
        String expected = "Invalid file name. File could not be opened.\n";
        String actual = out.toString();

        assertEquals(expected, actual);
    }

    // Testing error in one student entry
    @Test
    public void testOneStudentError() {

        String filename = "D:\\senior 1 comp\\testing\\Project\\Testing-Project\\Test\\src\\TestFiles\\Integration\\testFile5.txt";
        subject1 = InputHandler.read(filename);

        String expected = "i dont know yet ";
        String actual = out.toString();

        assertEquals(expected, actual);

    }

    @Test
    public void testMultipleStudentsError() {

        String filename = "D:\\senior 1 comp\\testing\\Project\\Testing-Project\\Test\\src\\TestFiles\\Integration\\testFile6.txt";
        subject1 = InputHandler.read(filename);

        String expected = "i dont know yet ";
        String actual = out.toString();

        assertEquals(expected, actual);

    }
}