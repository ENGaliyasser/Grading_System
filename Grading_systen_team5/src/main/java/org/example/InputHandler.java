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
            reader = new BufferedReader(new FileReader(filename));// file reader function throws the
                                                                  // FileNotFoundException
            String line = reader.readLine();

            // Read the first line for subject data
            if (line != null && !line.isEmpty()) {
                subject = new Subject(line);
                String subjectValidationResult = SubjectValidator.checkSubjectData(subject);
                if (!subjectValidationResult.isEmpty()) {
                    System.out.print("Error in subject data:\n");
                    System.out.print(subjectValidationResult);
                    reader.close();
                    return null;
                }
            } else {
                System.out.print("No subject data found. Subject data must be in the first line.\n");
                reader.close();
                return null;
            }

            // Initialize array list for students
            subject.setStudents(new ArrayList<>());
            line = reader.readLine();
            if (line != null) {
                if (!line.isEmpty()) {
                    Student student = new Student(line);
                    String studentValidationResult = StudentValidator.checkStudentData(student);
                    if (!studentValidationResult.isEmpty()) {
                        System.out.print("Error in student data:\n");
                        System.out.print(studentValidationResult);
                    } else {
                        subject.getStudents().add(student);
                    }
                }
                // else { System.out.print(StudentValidator.STRING_EMPTY);return null;}
            } else {
                System.out.print(StudentValidator.STRING_EMPTY);
                return null;
            }
            // Read the remaining lines for student data
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    Student student = new Student(line);
                    String studentValidationResult = StudentValidator.checkStudentData(student);
                    if (!studentValidationResult.isEmpty()) {
                        System.out.print("Error in student data:\n");
                        System.out.print(studentValidationResult);
                    } else {
                        subject.getStudents().add(student);
                    }
                }
                // else { System.out.print(StudentValidator.STRING_EMPTY);return null;}

            }

            reader.close();

        } catch (IOException e) {
            System.out.print("Invalid file name. File could not be opened.\n");
            e.printStackTrace();
        }

        return subject;
    }
}
