package org.example;

import java.util.ArrayList;

public class Subject {
    String name;
    String code;
    int fullMark;
    ArrayList<Student> students;


    public Subject(String line){
        String[] attr = line.split(",");
        name = attr[0];
        code = attr[1];
        fullMark = Integer.valueOf(attr[2]);
        students = new ArrayList<>();
    }

    public Subject(String name, String code, int fullMark)
    {
        this.name = name;
        this.code = code;
        this.fullMark = fullMark;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getFullMark() {
        return fullMark;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setFullMark(int fullMark) {
        this.fullMark = fullMark;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}

