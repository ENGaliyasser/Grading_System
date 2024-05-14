package org.integrationTest;

import org.example.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;

public class MainIntegration {
    private ByteArrayOutputStream out;

    @BeforeEach
    void Init() {
        out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
    }

    @Test
    void testMainIntegration1() throws FileNotFoundException {
        String path[] = {
                "C:\\Users\\youssef\\Desktop\\programing\\Testing\\project\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\NoErrors.txt" };
        Main.main(path);
        String actual = out.toString();
        String expectedString = "Table successfully written to output.txt\r\n"
                + "Subject Name: Software testing\t\tMax Mark: 100\n\n" +
                "+----------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+----------+-----------------+--------+-------+\n" +
                "| aliiiii  | 12345678        | 4.0    | A     |\r\n" +
                "| shebll   | 12345679        | 0.0    | F     |\r\n" +
                "| nohha    | 12345670        | 4.0    | A+    |\r\n" +
                "| doniaa   | 12345670        | 4.0    | A+    |\r\n" +
                "| rezkk    | 12345677        | 4.0    | A+    |\r\n" +
                "| caroll   | 12345670        | 4.0    | A+    |\r\n" +
                "+----------+-----------------+--------+-------+\n\r\n";
        assertEquals(expectedString, actual);

    }

    @Test
    void testMainIntegration2() throws FileNotFoundException {
        String path[] = {
                "C:\\Users\\youssef\\Desktop\\programing\\Testing\\project\\Grading_System\\Grading_systen_team5\\src\\main\\resources\\EmptyStudent.txt" };
        Main.main(path);
        String actual = out.toString();
        String expectedString = StudentValidator.STRING_EMPTY;
        assertEquals(expectedString, actual);

    }

    private Subject createValidSubject() {
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("Alice", "12345678", 10, 10, 20, 60));
        subject.getStudents().add(new Student("Bob", "87654321", 8, 9, 18, 55));
        return subject;
    }
}
