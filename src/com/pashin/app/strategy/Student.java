package com.pashin.app.strategy;

import java.util.Arrays;

public class Student {

    private String lastname;

    private Subject[] subjects;

    private double average;

    public Student() { }

    public Student(String lastname, Subject[] subjects, double average) {
        this.lastname = lastname;
        this.subjects = subjects;
        this.average = average;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lastname='" + lastname + '\'' +
                ", subjects=" + Arrays.toString(subjects) +
                ", average=" + average +
                '}';
    }

    public double calculateAverage() {
        double average = 0;
        for (Subject subject : subjects) {
            average += subject.getMark();
        }
        average /= subjects.length;
        return average;
    }
}
