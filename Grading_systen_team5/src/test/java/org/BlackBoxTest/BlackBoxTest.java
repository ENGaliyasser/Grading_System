package org.BlackBoxTest;

import org.example.Main;
import org.example.StudentValidator;

import org.example.SubjectValidator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.PublicKey;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BlackBoxTest {

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


//////////////////////////// Boundary Value Analysis on Activities Mark //////////////////////
    @Test
    public void BVA_ActivitiesBelowMin() throws IOException {
/// ACTIVITIES BELOW MIN
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,-1,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
        assertEquals("Error in student data:\n"+
                StudentValidator.ERROR_ACTIVITES_MARK+
                "Table successfully written to output.txt\r\n"+
                "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                "+---+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+---+-----------------+--------+-------+\n" +
                "+---+-----------------+--------+-------+\n\r\n",output.toString());


/// ACTIVITIES MIN
    }
    @Test
    public void BVA_ActivitiesAtMin() throws IOException {
/// ACTIVITIES MIN
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,0,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
        assertEquals(
                "Table successfully written to output.txt\r\n"+
                "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                "+--------+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_ActivitiesAboveMin() throws IOException {
/// ACTIVITIES MIN
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,1,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());}
    @Test
    public void BVA_ActivitiesAtNorm() throws IOException {
/// ACTIVITIES NORM
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,7,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 4.0    | A+    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_ActivitiesBelowMax() throws IOException {
/// ACTIVITIES MAX
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,9,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 4.0    | A+    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_ActivitiesAtMax() throws IOException {
/// ACTIVITIES MAX
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,10,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 4.0    | A+    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_ActivitiesAboveMax() throws IOException {
/// ACTIVITIES ABOVE MAX
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,11,10,20,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
        StudentValidator.ERROR_ACTIVITES_MARK+
                "Table successfully written to output.txt\r\n"+
                "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                "+---+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+---+-----------------+--------+-------+\n" +
                "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }

    //////////////////////////// Boundary Value Analysis on Midterm Mark ///////////////////////////////////
    @Test
    public void BVA_MidtermBelowMin() throws IOException {
/// MIDTERM BELOW MIN
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,10,-1,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals("Error in student data:\n"+
                StudentValidator.ERROR_MIDTERM_MARK+
                "Table successfully written to output.txt\r\n"+
                "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                "+---+-----------------+--------+-------+\n" +
                "| Student name| Student number  | GPA    | Grade |\n" +
                "+---+-----------------+--------+-------+\n" +
                "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_MidtermAtMin() throws IOException {
/// MIDTERM MIN
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,10,0,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 2.7    | B-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_MidtermAboveMin() throws IOException {
/// MIDTERM MIN
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,10,1,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 2.7    | B-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_MidtermAtNorm() throws IOException {
/// MIDTERM NORM
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,7,10,17,60\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 4.0    | A     |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_MidtermBelowMax() throws IOException {
/// MIDTERM MAX
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,8,19,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 4.0    | A     |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_MidtermAtMax() throws IOException {
/// MIDTERM MAX
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,8,20,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 4.0    | A     |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void BVA_MidtermAboveMax() throws IOException {
/// MIDTERM ABOVE MAX
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,8,22,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.ERROR_MIDTERM_MARK+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }


    //////////////////////////// Equivalence Class Partitioning on Oral Mark ///////////////////////////
    @Test
    public void EQU_OralInvalidBelowClass() throws IOException {
/// Equivalent class of Oral Mark Invalid Below Class
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,-2,18,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.ERROR_ORAL_MARK+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void EQU_OralValidClass() throws IOException {
/// Equivalent class of Oral Mark Valid Class
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,6,18,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void EQU_OralInvalidAboveClass() throws IOException {
/// Equivalent class of Oral Mark Invalid Above Class
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,13,18,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.ERROR_ORAL_MARK+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }


    //////////////////////////// Equivalence Class Partitioning on Final Mark /////////////////////////////
    @Test
    public void EQU_FinalInvalidBelowClass() throws IOException {
/// Equivalent class of Final Mark Invalid Below Class
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,8,18,-2\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.ERROR_FINAL_MARK+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void EQU_FinalValidClass() throws IOException {
/// Equivalent class of Final Mark Valid Class
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,6,18,58\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void EQU_FinalInvalidAboveClass() throws IOException {
/// Equivalent class of Final Mark Invalid Above Class
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,8,18,70\n");
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.ERROR_FINAL_MARK+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }

    //////////////////////////// Decision Table on Subject Code  /////////////////////////////
    @Test
    public void SubjectCodeRule1() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,abcefhij,100\n" +
                    "Donia,20004000,8,8,18,56\n"); //Testing a subject code longer than the max
        }


        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in subject data:\n"+
                        SubjectValidator.SUBJECT_CODE_INVALID_LENGTH,output.toString());
    }
    @Test
    public void SubjectCodeRule2() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,ab3456,100\n" +
                    "Donia,20004000,8,8,18,56\n");
            //Testing a subject code of 6 chars but not having the first 3 alphabetical
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in subject data:\n"+
                        SubjectValidator.SUBJECT_CODE_HAS_NUMBERS,output.toString());
    }

    @Test
    public void SubjectCodeRule3() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,abcd56,100\n" +
                    "Donia,20004000,8,8,18,56\n");
            //Testing a subject code of chars having the first 3 alphabetical
            // but not the 2nd 3 all numerical
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in subject data:\n"+
                        SubjectValidator.SUBJECT_CODE_HAS_LETTERS,output.toString());
    }

    @Test
    public void SubjectCodeRule4() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,abc4567,100\n" +
                    "Donia,20004000,8,8,18,56\n");
            //Testing valid subject code of 7 first 3 alph and second 3 numericalchars
            // but the 7th not 's'
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in subject data:\n"+
                        SubjectValidator.SUBJECT_CODE_END,output.toString());
    }

    @Test
    public void SubjectCodeRule5() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,abc456s,100\n" +
                    "Donia,20004000,8,8,18,56\n");
            //Testing valid subject code of 7 chars and ending with 's'
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }
    @Test
    public void SubjectCodeRule6() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,abc456,100\n" +
                    "Donia,20004000,8,8,18,56\n");
            //Testing subject code of 6 chars and first 3 alph and second 3 numerical
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }


//////////////////////////// Decision Table on Check Student Name  /////////////////////////////
@Test
public void StudNameRule1() throws IOException {
    Path tempFile = tempDir.resolve("tempFile.txt");
    try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
        writer.write("Math,phm123,100\n" +
                ",20004000,8,8,18,56\n"); //Testing a student data with empty name
    }


    String[] arr=new String[]{tempFile.toString()};

    Main.main(arr);
   assertEquals(
            "Error in student data:\n"+
            StudentValidator.STRING_EMPTY+
            "Table successfully written to output.txt\r\n"+
            "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
            "+---+-----------------+--------+-------+\n" +
            "| Student name| Student number  | GPA    | Grade |\n" +
            "+---+-----------------+--------+-------+\n" +
            "+---+-----------------+--------+-------+\n\r\n",output.toString());
}
    @Test
    public void StudNameRule2() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    " Doni@,20004000,8,8,18,56\n");
            //Testing a student data with a student name that starts with space
            // and has non-alphabetic char in it
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.STUDENT_NAME_SPACE+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }

    @Test
    public void StudNameRule3() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    " Donia,20004000,8,8,18,56\n");
            //Testing a student data with a student name that starts with space
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.STUDENT_NAME_SPACE+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }

    @Test
    public void StudNameRule4() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Doni@,20004000,8,8,18,56\n");
            //Testing a student data with a student name that has non-alphabetic char in it
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Error in student data:\n"+
                        StudentValidator.STUDENT_NAME_INVALID+
                        "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+---+-----------------+--------+-------+\n" +
                        "+---+-----------------+--------+-------+\n\r\n",output.toString());
    }

    @Test
    public void StudNameRule5() throws IOException {
        Path tempFile = tempDir.resolve("tempFile.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(tempFile)) {
            writer.write("Math,phm123,100\n" +
                    "Donia,20004000,8,8,18,56\n");
            //Testing valid student name
        }
        String[] arr=new String[]{tempFile.toString()};

        Main.main(arr);
       assertEquals(
                "Table successfully written to output.txt\r\n"+
                        "Subject Name: Math"+"\t\t"+"Max Mark: 100\n\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Student name| Student number  | GPA    | Grade |\n" +
                        "+--------+-----------------+--------+-------+\n" +
                        "| Donia  | 20004000        | 3.7    | A-    |\r\n"+
                        "+--------+-----------------+--------+-------+\n\r\n",output.toString());
    }


}
