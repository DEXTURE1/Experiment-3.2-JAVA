package com.springhibernate;

/**
 * Student class - depends on Course (Part A: Dependency Injection)
 */
public class Student {
    private String studentName;
    private Course course; // Dependency Injection - Course will be injected via Spring

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(String studentName, Course course) {
        this.studentName = studentName;
        this.course = course;
    }

    // Getters and Setters
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Method to display student and course details
    public void displayCourseDetails() {
        System.out.println("==========================================");
        System.out.println("Student Name: " + studentName);
        if (course != null) {
            System.out.println("Enrolled Course: " + course.getCourseName());
            System.out.println("Course Duration: " + course.getDuration() + " months");
            System.out.println("✅ Dependency Injection Successful!");
        } else {
            System.out.println("No course enrolled.");
        }
        System.out.println("==========================================\n");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", course=" + course +
                '}';
    }
}
