package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class InputHandlerTest  {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @TempDir
    Path tempDir;

    @BeforeEach
    public void setupStream() {
        // MockitoAnnotations.initMocks(this);
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void cleanupStream() {
        System.setOut(null);
    }

    @Test
    public void readFileNotValid() {

        InputHandler.read("filenot valid");
        assertEquals("Invalid file name. File could not be opened.\n",output.toString());
    }

    @Test
    public void SubjValidFalseSubjCode() throws IOException {

        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm,100\n" +
                    "Donia,20004001,10,10,20,60\n");
        }
        InputHandler.read(tempFile.toString());//enter valid name
        assertEquals("Error in subject data:\nError: Subject code must be 6 or 7 characters.\n", output.toString());
    }

    @Test
    public void SubjValidFalseSubjMark() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,60\n" +
                    "Donia,20004001,10,10,20,60\n");
        }
        InputHandler.read(tempFile.toString());//enter valid name

        assertEquals("Error in subject data:\nError: Max degree must be one of the following values: 100.\n", output.toString());
    }

    @Test//CAN'T DO THE MOCK SO ITS TESTED ON REAL FILE
    public void lineEmpty() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("\n" +
                    "Donia,20004001,10,10,20,60\n");
        }
        InputHandler.read(tempFile.toString());//enter valid name

        assertEquals("No subject data found. Subject data must be in the first line.\n",output.toString());
    }

    @Test//CAN'T DO THE MOCK SO IT'S TESTED ON REAL FILE
    public void StudValidTrue() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004001,10,10,20,60\n" +
                    "Noha,20004002,9,10,15,50\n" +
                    "Carol,20004003,10,10,20,30\n");
        }
        InputHandler.read(tempFile.toString());
        assertNotEquals("Error in student data:\n",output.toString());
    }

    @Test
    public void StudValidFalse() throws IOException {//having two errors one at coe not 8 and 2nd is activity for noha is 20
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004001,10,10,20,60\n" +
                    "Noha,2000400,20,10,15,50\n" +
                    "Carol,20004003,10,10,20,30\n");
        }
        InputHandler.read(tempFile.toString());
       assertEquals("Error in student data:\nError: student number length must be 8 characters.\n" +
               "Error: activities mark must be an integer from 1 to 10 of the full mark.\n",output.toString());

    }

    @Test
    public void StudEmpty() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n");
        }
        InputHandler.read(tempFile.toString());
        assertEquals("Error in student data:\n",output.toString());

    }
}