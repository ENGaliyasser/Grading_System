package org.integrationTest;

import org.example.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

public class CheckOutputHandlerWriteFile {

    @Test
    void testWriteFileOutput1() {
        Subject sbj = createValidSubject();
        OutputHandler.writeFile(sbj);

        File outFile = new File("output.txt");
        assertTrue(outFile.exists());
    }

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

    private Subject createValidSubject() {
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("Alice", "12345678", 10, 10, 20, 60));
        subject.getStudents().add(new Student("Bob", "87654321", 8, 9, 18, 55));
        return subject;
    }

}
