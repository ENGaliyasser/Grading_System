package org.WhiteBoxTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.InputHandler;
import org.example.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BasisPathCoverageTest {
    private ByteArrayOutputStream out;

    @BeforeEach
    void Init() {
        out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
    }

    // Test Case 1: File is empty
    @Test
    public void test1() {
        String filename = "C:\\Users\\carol\\Downloads\\Grading_System-main (2)\\Grading_System-main\\Grading_systen_team5\\src\\main\\resources\\InputEmpty";
        InputHandler inputHandler = new InputHandler();
        Subject sub = inputHandler.read(filename);

        String actual = out.toString().trim();
        String expected = "No subject data found. Subject data must be in the first line.";
        assertEquals(expected, actual);
    }

    // Test Case 2: Valid subject data
    @Test
    public void test2() {
        String filename = "C:\\Users\\carol\\Downloads\\Grading_System-main (2)\\Grading_System-main\\Grading_systen_team5\\src\\main\\resources\\InputValid";
        InputHandler inputHandler = new InputHandler();
        Subject sub = inputHandler.read(filename);

        assertEquals("Software testing", sub.getName());
        assertEquals("CSE333", sub.getCode());
        assertEquals(100, sub.getFullMark());
    }
    
    // Test Case 3: Subject data but no Student data
    @Test
    public void test3() {
        String filename = "C:\\Users\\carol\\Downloads\\Grading_System-main (2)\\Grading_System-main\\Grading_systen_team5\\src\\main\\resources\\InputSubjectNoStudents.txt";
        Subject sub = InputHandler.read(filename);

        // Verify that when there are no students, the returned Subject object is null
        assertEquals(null, sub);
    }

    // Test Case 4: Subject Data not in first line
    @Test
    public void test4() {
        String filename = "C:\\Users\\carol\\Downloads\\Grading_System-main (2)\\Grading_System-main\\Grading_systen_team5\\src\\main\\resources\\InputSubjectNotInFirstLine.txt";
        InputHandler inputHandler = new InputHandler();
        Subject sub = inputHandler.read(filename);

        String actual = out.toString().trim();
        String expected = "No subject data found. Subject data must be in the first line.";
        assertEquals(expected, actual);
    }

    // Test Case 5: Valid subject data but wrong student data
    @Test
    public void test5() {
        String filename = "C:\\Users\\carol\\Downloads\\Grading_System-main (2)\\Grading_System-main\\Grading_systen_team5\\src\\main\\resources\\InputCorrectSubjectWrongStudents.txt";
        InputHandler inputHandler = new InputHandler();
        Subject sub = inputHandler.read(filename);

        assertEquals("Software testing", sub.getName());
        assertEquals("CSE333", sub.getCode());
        assertEquals(100, sub.getFullMark());
        assertEquals(3, sub.getStudents().size());
    }

    // Test Case 6: File does not exist
    @Test
    public void test6() {
        String filename = "InputNonExistent.txt";
        InputHandler inputHandler = new InputHandler();
        Subject sub = inputHandler.read(filename);

        assertEquals(null, sub);
    }
}
