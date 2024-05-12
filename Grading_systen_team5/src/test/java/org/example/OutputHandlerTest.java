package org.example;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

public class OutputHandlerTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final String testFilePath = "testOutput.txt";

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        deleteTestFile();
    }

    private void deleteTestFile() {
        File file = new File(testFilePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testWriteWithValidSubject() {
        // Create a subject with known students and marks
        Subject subject = createValidSubject();

        // Call the write method
        String output = OutputHandler.write(subject);

        // Assert output contains expected format
        assertNotNull(output);
        assertTrue(output.contains("Subject Name: TestSubject"));
        assertTrue(output.contains("Max Mark: 100"));
        assertTrue(output.contains("| Student name"));
    }

    @Test
    public void testWriteWithEmptySubject() {
        // Create an empty subject
        Subject emptySubject = new Subject("EmptySubject", "CS101", 100);

        // Call the write method
        String output = OutputHandler.write(emptySubject);

        // Expected output for an empty subject
        String expectedOutput = "Subject Name: EmptySubject\t\tMax Mark: 100\n\n+---+-----------------+--------+-------+\n"
                +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+---+-----------------+--------+-------+\n" +
                "+---+-----------------+--------+-------+\n";

        // Assert output matches the expected output
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testWriteWithOneStudent() {
        // Create a subject with one student
        Subject oneStudentSubject = new Subject("OneStudentSubject", "CS102", 100);
        oneStudentSubject.getStudents().add(new Student("John Doe", "12345678", 10, 7, 20, 50));

        // Call the write method
        String output = OutputHandler.write(oneStudentSubject);

        // Expected output for one student
        String expectedOutput = "Subject Name: OneStudentSubject\t\tMax Mark: 100\n\n+-----------+-----------------+--------+-------+\n"
                +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+-----------+-----------------+--------+-------+\n" +
                "| John Doe  | 12345678        | 3.3    | B+    |\r\n" +
                "+-----------+-----------------+--------+-------+\n";

        // Assert output matches the expected output
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testWriteWithMultipleStudents() {
        // Create a subject with multiple students
        Subject multiStudentSubject = new Subject("MultiStudentSubject", "CS103", 100);
        multiStudentSubject.getStudents().add(new Student("Alice", "11111111", 10, 10, 20, 60));
        multiStudentSubject.getStudents().add(new Student("Bob", "22222222", 8, 9, 18, 55));

        // Call the write method
        String output = OutputHandler.write(multiStudentSubject);

        // Expected output for multiple students
        String expectedOutput = "Subject Name: MultiStudentSubject\t\tMax Mark: 100\n\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Alice  | 11111111        | 4.0    | A+    |\r\n" +
                "| Bob    | 22222222        | 3.7    | A-    |\r\n" +
                "+--------+-----------------+--------+-------+\n";

        // Assert output matches the expected output
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testWriteFileOutput() {
        // Create a subject with known students and marks
        Subject subject = createValidSubject();

        // Call the writeFile method
        OutputHandler.writeFile(subject);

        // Check if the file "output.txt" exists
        File outputFile = new File("output.txt");
        assertTrue(outputFile.exists());

        // Read the content of the file
        String fileContent = null;
        try {
            fileContent = Files.readString(outputFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Check if the content matches the expected output
        assertNotNull(fileContent);
        assertTrue(fileContent.contains("Subject Name: TestSubject"));
        assertTrue(fileContent.contains("Max Mark: 100"));
        assertTrue(fileContent.contains("| Student name"));
    }

    @Test
    public void testWriteWithSubjectNameSpecialCharacters() {
        // Create a subject with a name containing special characters
        Subject specialCharsSubject = new Subject("Special!@#$%^&*()-=+Subject", "CS105", 100);

        // Call the write method
        String output = OutputHandler.write(specialCharsSubject);

        // Assert output contains the subject name with special characters
        assertTrue(output.contains("Subject Name: Special!@#$%^&*()-=+Subject"));
    }

    @Test
    public void testWriteWithStudentNameSpecialCharacters() {
        // Create a student with a name containing special characters
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("John_Doe", "12345678", 10, 7, 20, 50));

        // Call the write method
        String output = OutputHandler.write(subject);

        // Assert output contains the student name with special characters
        assertTrue(output.contains("| John_Doe"));
    }

    @Test
    public void testWriteWithNoStudents() {
        // Create a subject with no students
        Subject noStudentsSubject = new Subject("NoStudentsSubject", "CS106", 100);

        // Call the write method
        String output = OutputHandler.write(noStudentsSubject);

        // Expected output for no students
        String expectedOutput = "Subject Name: NoStudentsSubject\t\tMax Mark: 100\n\n" +
                "+---+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+---+-----------------+--------+-------+\n" +
                "+---+-----------------+--------+-------+\n";

        // Assert output matches the expected output
        assertEquals(expectedOutput, output);
    }

    private Subject createValidSubject() {
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("Alice", "12345678", 10, 10, 20, 60));
        subject.getStudents().add(new Student("Bob", "87654321", 8, 9, 18, 55));
        return subject;
    }
}
