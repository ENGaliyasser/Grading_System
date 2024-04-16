package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class OutputHandler {

    public static String write(Subject subject) {

        // Build the table string
        StringBuilder sb = new StringBuilder();

        sb.append("Subject Name: " + subject.getName() + "\t\t" + "Max Mark: " + subject.getFullMark() + "\n\n");

        // Determine the maximum length of the student name
        int maxNameLength = 0;
        for (Student st : subject.getStudents()) {
            maxNameLength = Math.max(maxNameLength, st.getName().length());
        }

        // Format specifier string with variable length
        String format = "| %-" + (maxNameLength + 2) + "s| %-15s | %-6s | %-5s |%n";

        /* Formatting the start line of the table */
        sb.append("+");
        for (int i = 0; i < maxNameLength + 3; i++) {
            sb.append("-");
        }
        sb.append("+-----------------+--------+-------+\n");

        /* Formatting the second line which contains the attributes of the table */
        sb.append("| Student name");
        for (int i = 0; i < maxNameLength - 10; i++) {
            sb.append(" ");
        }
        sb.append("| Student number  | GPA    | Grade |\n");
        sb.append("+");
        for (int i = 0; i < maxNameLength + 3; i++) {
            sb.append("-");
        }
        sb.append("+-----------------+--------+-------+\n");

        /* Adding the list of students into the table with the specified format */
        for (Student st : subject.getStudents()) {
            st.getSum();
            sb.append(String.format(format, st.getName(), st.getStudentNumber(), st.calculateGPA(), st.calculateGrade()));
        }

        /* Formatting the end line of the table */
        sb.append("+");
        for (int i = 0; i < maxNameLength + 3; i++) {
            sb.append("-");
        }
        sb.append("+-----------------+--------+-------+\n");

        /* Returning this Table as a String to be written into the output file */
        return sb.toString();
    }

    public static void writeFile(Subject subject) {
        String table = write(subject);

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(table);
            writer.close();
            System.out.println("Table successfully written to output.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while writing the table to output.txt: " + e.getMessage());
        }
    }
}


