package com.springhibernate.entity;

import jakarta.persistence.*;

/**
 * StudentEntity - Entity class for Part B: Hibernate CRUD Operations
 */
@Entity
@Table(name = "student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "department", length = 50)
    private String department;

    @Column(name = "marks")
    private double marks;

    // Default constructor (required by Hibernate)
    public StudentEntity() {
    }

    // Parameterized constructor
    public StudentEntity(String name, String department, double marks) {
        this.name = name;
        this.department = department;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("StudentEntity[id=%d, name='%s', department='%s', marks=%.2f]",
                id, name, department, marks);
    }
}
