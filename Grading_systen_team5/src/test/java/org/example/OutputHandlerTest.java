package org.example;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.*;

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
        String expectedOutput = "Subject Name: EmptySubject\t\tMax Mark: 100\n\n";

        // Assert output matches the expected output
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testWriteWithOneStudent() {
        // Create a subject with one student
        Subject oneStudentSubject = new Subject("OneStudentSubject", "CS102", 100);
        oneStudentSubject.getStudents().add(new Student("John Doe", "12345678", 10, 10, 20, 60));

        // Call the write method
        String output = OutputHandler.write(oneStudentSubject);

        // Assert output contains data for one student
        assertNotNull(output);
        assertTrue(output.contains("Subject Name: OneStudentSubject"));
        assertTrue(output.contains("Max Mark: 100"));
        assertTrue(output.contains("| Student name: John Doe"));
    }

    @Test
    public void testWriteWithMultipleStudents() {
        // Create a subject with multiple students
        Subject multiStudentSubject = new Subject("MultiStudentSubject", "CS103", 100);
        multiStudentSubject.getStudents().add(new Student("Alice", "11111111", 10, 10, 20, 60));
        multiStudentSubject.getStudents().add(new Student("Bob", "22222222", 8, 9, 18, 55));

        // Call the write method
        String output = OutputHandler.write(multiStudentSubject);

        // Assert output contains data for both students
        assertNotNull(output);
        assertTrue(output.contains("Subject Name: MultiStudentSubject"));
        assertTrue(output.contains("Max Mark: 100"));
        assertTrue(output.contains("| Student name: Alice"));
        assertTrue(output.contains("| Student name: Bob"));
    }

    @Test
    public void testWriteFile() {
        // Create a subject with known students and marks
        Subject subject = createValidSubject();

        // Call the writeFile method
        OutputHandler.writeFile(subject);

        // Verify that the file was created
        File outputFile = new File(testFilePath);
        assertTrue(outputFile.exists());

        // Verify that the file contains the expected content
        try {
            String expectedContent = OutputHandler.write(subject);
            String actualContent = new String(Files.readAllBytes(outputFile.toPath()));
            assertEquals(expectedContent, actualContent);
        } catch (IOException e) {
            fail("Error reading file content: " + e.getMessage());
        }
    }

    @Test
    public void testWriteFileWithNullSubject() {
        // Mock the OutputHandler
        OutputHandler outputHandler = new OutputHandler();

        // Call the write method with null subject
        String output = outputHandler.write(null);

        // Assert that the output is an empty string
        assertEquals("", output);
    }

    @Test
    public void testWriteFileWithEmptySubject() {
        // Test subject data
        Subject subject = new Subject("", "", 0);

        // Mock the OutputHandler
        OutputHandler outputHandler = new OutputHandler();

        // Call the write method with empty subject
        String output = outputHandler.write(subject);

        // Assert that the output is an empty string
        assertEquals("", output);
    }

    private Subject createValidSubject() {
        Subject subject = new Subject("TestSubject", "CS101", 100);
        subject.getStudents().add(new Student("Alice", "12345678", 10, 10, 20, 60));
        subject.getStudents().add(new Student("Bob", "87654321", 8, 9, 18, 55));
        return subject;
    }
}
