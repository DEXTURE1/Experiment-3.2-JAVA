package com.springhibernate;

/**
 * Course class - represents a Course entity for Part A: Dependency Injection
 */
public class Course {
    private String courseName;
    private int duration; // in months

    // Default constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getters and Setters
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", duration=" + duration + " months" +
                '}';
    }
}
