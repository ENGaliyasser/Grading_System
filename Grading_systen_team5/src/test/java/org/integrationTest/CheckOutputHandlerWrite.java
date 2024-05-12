package org.integrationTest;

import org.example.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class CheckOutputHandlerWrite {
    @Test
    void testCalcGradeGPAGetters1() {
        Subject sbj = createValidSubject();
        String output = OutputHandler.write(sbj);
        String expectedOutput = "Subject Name: TestSubject\t\tMax Mark: 100\n\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Alice  | 12345678        | 4.0    | A+    |\r\n" +
                "| Bob    | 87654321        | 3.7    | A-    |\r\n" +
                "+--------+-----------------+--------+-------+\n";
        assertEquals(expectedOutput, output);

    }

    @Test
    void testCalcGradeGPAGetters2() {
        Subject sbj = createValidSubject();
        sbj.getStudents().get(0).setSum(0);
        sbj.getStudents().get(1).setSum(0);

        String output = OutputHandler.write(sbj);
        String expectedOutput = "Subject Name: TestSubject\t\tMax Mark: 100\n\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Alice  | 12345678        | 0.0    | F     |\r\n" +
                "| Bob    | 87654321        | 0.0    | F     |\r\n" +
                "+--------+-----------------+--------+-------+\n";
        assertEquals(expectedOutput, output);

    }

    @Test
    void testCalcGradeGPAGetters3() {
        Subject sbj = createValidSubject();
        sbj.getStudents().get(0).setSum(-12);
        sbj.getStudents().get(1).setSum(70);

        String output = OutputHandler.write(sbj);
        String expectedOutput = "Subject Name: TestSubject\t\tMax Mark: 100\n\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Alice  | 12345678        | -1.0   | Error: the sum of marks must be a positive number between 0 and 100.\n |\r\n"
                +
                "| Bob    | 87654321        | 2.0    | C     |\r\n" +
                "+--------+-----------------+--------+-------+\n";
        assertEquals(expectedOutput, output);

    }

    private Subject createValidSubject() {
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("Alice", "12345678", 10, 10, 20, 60));
        subject.getStudents().add(new Student("Bob", "87654321", 8, 9, 18, 55));
        return subject;
    }
}
