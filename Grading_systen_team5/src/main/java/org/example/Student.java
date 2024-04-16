package org.example;

public class Student {
    private String name;
    private String number;
    private int activitiesMark;
    private int oralPracticalMark;
    private int midtermMark;
    private int finalMark;
    private int sum;
    public final static String ERROR_SUM = "Error: the sum of marks must be a positive number between 0 and 100.\n";
    public final static int    ERROR_GPA = -1;
    public Student(String name, String number, int activitiesMark, int oralPracticalMark, int midtermMark, int finalMark) {
        this.name = name;
        this.number = number;
        this.activitiesMark = activitiesMark;
        this.oralPracticalMark = oralPracticalMark;
        this.midtermMark = midtermMark;
        this.finalMark = finalMark;
        sum = activitiesMark + oralPracticalMark + midtermMark + finalMark;

    }



    public Student(String s) {
        String[] attr = s.split(",");
        name = attr[0];
        number = attr[1];
        activitiesMark = Integer.valueOf(attr[2]);
        oralPracticalMark = Integer.valueOf(attr[3]);
        midtermMark = Integer.valueOf(attr[4]);
        finalMark = Integer.valueOf(attr[5]);
        sum = activitiesMark + oralPracticalMark + midtermMark + finalMark;
    }

    // Getters for student attributes

    public String getName()
    {
        return name;
    }

    public String getStudentNumber()
    {
        return number;
    }

    public int getActivitiesMark()
    {
        return activitiesMark;
    }
    public int getOral_practicalMark()
    {
        return oralPracticalMark;
    }
    public int getMidtermMark()
    {
        return midtermMark;
    }
    public int getFinalMark()
    {
        return finalMark;
    }

    public int getSum()
    {
        return sum;
    }

    public static double calculateGPA(int sum) {
        if (sum >= 93)
            return 4.0;
        else if (sum >= 90 && sum < 93)
            return 3.7;
        else if (sum >= 84 && sum < 90)
            return 3.3;
        else if (sum >= 80 && sum < 84)
            return 3.0;
        else if (sum >= 76 && sum < 80)
            return 2.7;
        else if (sum >= 73 && sum < 76)
            return 2.3;
        else if (sum >= 70 && sum < 73)
            return 2.0;
        else if (sum >= 67 && sum < 70)
            return 1.7;
        else if (sum >= 64 && sum < 67)
            return 1.3;
        else if (sum >= 60 && sum < 64)
            return 1.0;
        else if(sum<60 && sum>0)
            return 0;
        else return ERROR_GPA;


    }
    public String calculateGrade() {
        if (sum >= 97)
            return "A+";
        else if (sum >= 93 && sum < 97)
            return "A";
        else if (sum >= 90 && sum < 93)
            return "A-";
        else if (sum >= 84 && sum < 90)
            return "B+";
        else if (sum >= 80 && sum < 84)
            return "B";
        else if (sum >= 76 && sum < 80)
            return "B-";
        else if (sum >= 73 && sum < 76)
            return "C+";
        else if (sum >= 70 && sum < 73)
            return "C";
        else if (sum >= 67 && sum < 70)
            return "C-";
        else if (sum >= 64 && sum < 67)
            return "D+";
        else if (sum >= 60 && sum < 64)
            return "D";
        else if(sum<60 && sum>0)
            return "F";
        else return ERROR_SUM;
    }

    public double calculateGPA() {
        if (sum >= 93)
            return 4.0;
        else if (sum >= 90 && sum < 93)
            return 3.7;
        else if (sum >= 84 && sum < 90)
            return 3.3;
        else if (sum >= 80 && sum < 84)
            return 3.0;
        else if (sum >= 76 && sum < 80)
            return 2.7;
        else if (sum >= 73 && sum < 76)
            return 2.3;
        else if (sum >= 70 && sum < 73)
            return 2.0;
        else if (sum >= 67 && sum < 70)
            return 1.7;
        else if (sum >= 64 && sum < 67)
            return 1.3;
        else if (sum >= 60 && sum < 64)
            return 1.0;
        else if(sum<60 && sum>0)
            return 0;
        else return ERROR_GPA;


    }
    public static String calculateGrade(int sum) {
        if (sum >= 97)
            return "A+";
        else if (sum >= 93 && sum < 97)
            return "A";
        else if (sum >= 90 && sum < 93)
            return "A-";
        else if (sum >= 84 && sum < 90)
            return "B+";
        else if (sum >= 80 && sum < 84)
            return "B";
        else if (sum >= 76 && sum < 80)
            return "B-";
        else if (sum >= 73 && sum < 76)
            return "C+";
        else if (sum >= 70 && sum < 73)
            return "C";
        else if (sum >= 67 && sum < 70)
            return "C-";
        else if (sum >= 64 && sum < 67)
            return "D+";
        else if (sum >= 60 && sum < 64)
            return "D";
        else if(sum<60 && sum>0)
            return "F";
        else return ERROR_SUM;
    }
}

