package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputHandler {

    public static Subject read(String filename) {
        BufferedReader reader;
        Subject subject = null;

        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();

            // Read the first line for subject data
            if (line != null && !line.isEmpty()) {
                subject = new Subject(line);
                String subjectValidationResult = SubjectValidator.checkSubjectData(subject);
                if (!subjectValidationResult.isEmpty()) {
                    System.out.println("Error in subject data:");
                    System.out.println(subjectValidationResult);
                    reader.close();
                    return null;
                }
            } else {
                System.out.println("No subject data found. Subject data must be in the first line.");
                reader.close();
                return null;
            }

            // Initialize array list for students
            subject.setStudents(new ArrayList<>());

            // Read the remaining lines for student data
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    Student student = new Student(line);
                    String studentValidationResult = StudentValidator.checkStudentData(student);
                    if (!studentValidationResult.isEmpty()) {
                        System.out.println("Error in student data:");
                        System.out.println(studentValidationResult);
                    } else {
                        subject.getStudents().add(student);
                    }
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Invalid file name. File could not be opened.");
            e.printStackTrace();
        }

        if (subject == null) {
            System.out.println("File is empty or contains no valid subject data.");
        }

        return subject;
    }
}

