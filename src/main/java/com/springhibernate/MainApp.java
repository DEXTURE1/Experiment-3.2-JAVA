package com.springhibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * MainApp - Main application for Part A: Dependency Injection Demo
 */
public class MainApp {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("    PART A: Spring Dependency Injection Demo");
        System.out.println("=".repeat(60) + "\n");

        try {
            // Initialize Spring Container using Java-based configuration
            System.out.println("Initializing Spring ApplicationContext...");
            ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
            System.out.println("✅ Spring Container initialized successfully!\n");

            // Retrieve Student bean from Spring container
            System.out.println("Retrieving Student bean from Spring Container...");
            Student student = context.getBean(Student.class);
            System.out.println("✅ Student bean retrieved successfully!\n");

            // Display course details via Student class
            student.displayCourseDetails();

            System.out.println("\n" + "=".repeat(60));
            System.out.println("    ✅ PART A COMPLETED SUCCESSFULLY!");
            System.out.println("=".repeat(60) + "\n");

        } catch (Exception e) {
            System.err.println("❌ Error in Spring Dependency Injection:");
            e.printStackTrace();
        }
    }
}
