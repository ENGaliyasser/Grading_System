package org.example;

import java.io.FileNotFoundException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Subject ali;

        if (args.length == 0) {
            ali = InputHandler.read(

                    "Grading_System\\Grading_systen_team5\\src\\main\\resources\\NoErrors.txt");
        } else {
            ali = InputHandler.read(args[0]);
        }

        if (ali != null) {
            String outputString = OutputHandler.write(ali);
            OutputHandler.writeFile(ali);
            System.out.println(outputString);
        }
    }
}