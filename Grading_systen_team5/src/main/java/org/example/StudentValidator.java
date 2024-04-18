package org.example;

public class StudentValidator {
    private final Student student;

    public StudentValidator(Student student) {
        this.student = student;
    }

    public final static String STRING_EMPTY = "Error: Student is empty.\n";
    public final static String STUDENT_NAME_SPACE = "Error: Student name starts with a space.\n";
    public final static String STUDENT_NAME_INVALID = "Error: Student name must consist of alphabetic characters and spaces.\n";
    public final static String STUDENT_NUMBER_CONTAIN = "Error: student number must be all digits until the last character.\n";
    public final static String STUDENT_NUMBER_END = "Error: student number must end with an alphabet/digit.\n";
    public final static String STUDENT_NUMBER_INVALID_LENGTH = "Error: student number length must be 8 characters.\n";
    public final static String ERROR_ACTIVITES_MARK = "Error: activities mark must be an integer from 1 to 10 of the full mark.\n";
    public final static String ERROR_MIDTERM_MARK = "Error: midterm mark must be an integer from 1 to 20 of the full mark.\n";
    public final static String ERROR_ORAL_MARK = "Error: Oral/Practical mark must be an integer from 1 to 10 of the full mark.\n";
    public final static String ERROR_FINAL_MARK = "Error: final exam mark must be an integer from 1 to 60 from the full mark.\n";

    public String checkStudentName() {
        String s = student.getName();
        if(s.isEmpty()) return STRING_EMPTY;
        if(s.charAt(0)==' ') return STUDENT_NAME_SPACE;
        for(char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                if(c!=' ') return STUDENT_NAME_INVALID;
            }
        }
        return "";
    }

    public String checkStudentNumber() {
        String s = student.getStudentNumber();
        if(s.length()!=8) return STUDENT_NUMBER_INVALID_LENGTH;

        for(int i = 0; i<7; i++) {
            if(!Character.isDigit(s.charAt(i)))
                return STUDENT_NUMBER_CONTAIN;
        }
        if(!Character.isAlphabetic(s.charAt(s.length()-1)) && !Character.isDigit(s.charAt(s.length()-1)))
            return STUDENT_NUMBER_END;

        return "";
    }

    public String checkActivities() {
        int activitiesMark = student.getActivitiesMark();
        String result = "";
        if(activitiesMark<0 || activitiesMark>10)  result=ERROR_ACTIVITES_MARK;
        return result;
    }

    public String checkOral() {
        int oralMark = student.getOral_practicalMark();
        String result = "";

        if(oralMark<0 || oralMark>10) result= ERROR_ORAL_MARK;

        return result;
    }

    public String checkMidterm() {
        int midtermMark = student.getMidtermMark();
        String result = "";

        if(midtermMark<0 || midtermMark>20) result=ERROR_MIDTERM_MARK;

        return result;
    }

    public String checkFinal() {
        int finalMark = student.getFinalMark();
        String result = "";

        if(finalMark<0 || finalMark>60) result+=ERROR_FINAL_MARK;
        return result;
    }

    public String checkStudentData() {
        String result = "";
        result+=checkStudentName();
        result+=checkStudentNumber();
        result+=checkActivities();
        result+=checkFinal();
        result+=checkOral();
        result+=checkMidterm();

        return result;
    }

    public static String checkStudentName(Student student) {
        String s = student.getName();
        if(s.length() == 0) return STRING_EMPTY;
        if(s.charAt(0) == ' ') return STUDENT_NAME_SPACE;
        for(char c : s.toCharArray()) {
            if(!Character.isAlphabetic(c)) {
                if(c != ' ') return STUDENT_NAME_INVALID;
            }
        }
        return "";
    }

    public static String checkStudentNumber(Student student) {
        String s = student.getStudentNumber();
        if(s.length() != 8) return STUDENT_NUMBER_INVALID_LENGTH;

        for(int i = 0; i < 7; i++) {
            if(!Character.isDigit(s.charAt(i))) return STUDENT_NUMBER_CONTAIN;
        }
        if(!Character.isAlphabetic(s.charAt(s.length() - 1)) && !Character.isDigit(s.charAt(s.length() - 1)))
            return STUDENT_NUMBER_END;

        return "";
    }

    public static String checkActivities(Student student) {
        int activitiesMark = student.getActivitiesMark();
        String result = "";
        if(activitiesMark < 0 || activitiesMark > 10)  result =ERROR_ACTIVITES_MARK;
        return result;
    }

    public static String checkOral(Student student) {
        int oralMark = student.getOral_practicalMark();
        String result = "";
        if(oralMark < 0 || oralMark > 10) result = ERROR_ORAL_MARK;
        return result;
    }

    public static String checkMidterm(Student student) {
        int midtermMark = student.getMidtermMark();
        String result = "";
        if(midtermMark < 0 || midtermMark > 20) result = ERROR_MIDTERM_MARK;
        return result;
    }

    public static String checkFinal(Student student) {
        int finalMark = student.getFinalMark();
        String result = "";
        if(finalMark < 0 || finalMark > 60) result += ERROR_FINAL_MARK;
        return result;
    }
    public static String checkStudentData(Student student) {
        StudentValidator validator = new StudentValidator(student);
        return validator.checkStudentData();
    }
}



