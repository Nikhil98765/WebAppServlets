package com.java.web.model;

public class Student {
    private String name;
    private String university;
    private String rollNumber;

    public Student(String name, String university, String rollNumber) {
        this.name = name;
        this.university = university;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                '}';
    }
}
