package org.integrationTest;

import org.example.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class CheckOutputHandlerWriteFile {
    private ByteArrayOutputStream out;

    @BeforeEach
    void Init() {
        out = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(out);
        System.setOut(print);
    }

    @Test
    void testWriteFileOutput1() {
        Subject sbj = createValidSubject();
        OutputHandler.writeFile(sbj);

        File outFile = new File("output.txt");
        assertTrue(outFile.exists() && (outFile.length() != 0), "File is empty.");
    }

    @Test
    void testWriteFileOutput2() {
        Subject sbj = createValidSubject();
        OutputHandler.writeFile(sbj);

        String expected = "Table successfully written to output.txt\r\n";
        String actual = out.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testWriteFileOutput3() {
        Subject sbj = createValidSubject();
        OutputHandler.writeFile(sbj);
        String content = new String();
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt", StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content = content + line + "\n";
            }
        } catch (IOException e) {
            // Handle IOException
            e.printStackTrace();
        }
        String expectedOutput = "Subject Name: TestSubject\t\tMax Mark: 100\n\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Alice  | 12345678        | 4.0    | A+    |\n" +
                "| Bob    | 87654321        | 3.7    | A-    |\n" +
                "+--------+-----------------+--------+-------+\n";
        assertEquals(expectedOutput, content);
    }

    @Test
    void testWriteFileOutput4() {
        Subject sbj = createValidSubject();
        File outFile = new File("output.txt");
        outFile.setReadOnly();
        OutputHandler.writeFile(sbj);

        String expected = "An error occurred while writing the table to output.txt: output.txt (Access is denied)\r\n";
        String actual = out.toString();
        outFile.setWritable(true);
        assertEquals(expected, actual);
    }

    private Subject createValidSubject() {
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("Alice", "12345678", 10, 10, 20, 60));
        subject.getStudents().add(new Student("Bob", "87654321", 8, 9, 18, 55));
        return subject;
    }

}
