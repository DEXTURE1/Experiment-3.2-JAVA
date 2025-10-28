package com.springhibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig - Java-based Spring Configuration for Part A: Dependency Injection
 * @Configuration annotation marks this class as a source of bean definitions
 */
@Configuration
public class AppConfig {

    /**
     * Bean definition for Course
     * @return Course object with predefined values
     */
    @Bean
    public Course course() {
        System.out.println("Creating Course Bean...");
        return new Course("Spring Framework & Hibernate ORM", 6);
    }

    /**
     * Bean definition for Student
     * @return Student object with Course dependency injected
     */
    @Bean
    public Student student() {
        System.out.println("Creating Student Bean with Course dependency...");
        Student student = new Student();
        student.setStudentName("John Doe");
        student.setCourse(course()); // Dependency Injection
        return student;
    }
}
