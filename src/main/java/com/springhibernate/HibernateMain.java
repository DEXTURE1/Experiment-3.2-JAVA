package com.springhibernate;

import com.springhibernate.entity.StudentEntity;

import java.util.List;

public class HibernateMain {
    
    public static void main(String[] args) {
        
        System.out.println("\n" + "=".repeat(80));
        System.out.println("🚀 PART B: Hibernate Application for Student CRUD Operations");
        System.out.println("=".repeat(80) + "\n");
        
        StudentDAO studentDAO = new StudentDAO();
        
        try {
            // ===== CREATE Operation =====
            System.out.println("\n" + "-".repeat(80));
            System.out.println("📝 1. CREATE Operation - Adding Students");
            System.out.println("-".repeat(80));
            
            StudentEntity student1 = new StudentEntity();
            student1.setName("Amit Kumar");
            student1.setDepartment("Computer Science");
            student1.setMarks(92.5);
            studentDAO.addStudent(student1);
            
            StudentEntity student2 = new StudentEntity();
            student2.setName("Priya Sharma");
            student2.setDepartment("Electronics");
            student2.setMarks(88.0);
            studentDAO.addStudent(student2);
            
            StudentEntity student3 = new StudentEntity();
            student3.setName("Rahul Verma");
            student3.setDepartment("Mechanical");
            student3.setMarks(85.5);
            studentDAO.addStudent(student3);
            
            // ===== READ Operation (Get All Students) =====
            System.out.println("\n" + "-".repeat(80));
            System.out.println("📖 2. READ Operation - Retrieving All Students");
            System.out.println("-".repeat(80));
            
            List<StudentEntity> students = studentDAO.getStudents();
            if (students != null && !students.isEmpty()) {
                System.out.println("\n" + String.format("%-5s %-25s %-20s %-10s", "ID", "Name", "Department", "Marks"));
                System.out.println("-".repeat(80));
                for (StudentEntity student : students) {
                    System.out.println(String.format("%-5d %-25s %-20s %-10.2f", 
                        student.getId(), 
                        student.getName(), 
                        student.getDepartment(), 
                        student.getMarks()));
                }
            }
            
            // ===== READ Operation (Get Student by ID) =====
            System.out.println("\n" + "-".repeat(80));
            System.out.println("🔍 3. READ Operation - Retrieving Student by ID");
            System.out.println("-".repeat(80));
            
            if (students != null && !students.isEmpty()) {
                int firstStudentId = students.get(0).getId();
                StudentEntity foundStudent = studentDAO.getStudentById(firstStudentId);
                if (foundStudent != null) {
                    System.out.println("Student Details:");
                    System.out.println("  ID: " + foundStudent.getId());
                    System.out.println("  Name: " + foundStudent.getName());
                    System.out.println("  Department: " + foundStudent.getDepartment());
                    System.out.println("  Marks: " + foundStudent.getMarks());
                }
            }
            
            // ===== UPDATE Operation =====
            System.out.println("\n" + "-".repeat(80));
            System.out.println("✏️ 4. UPDATE Operation - Updating Student Details");
            System.out.println("-".repeat(80));
            
            if (students != null && !students.isEmpty()) {
                StudentEntity studentToUpdate = students.get(0);
                System.out.println("Before Update: " + studentToUpdate.getName() + " - Marks: " + studentToUpdate.getMarks());
                
                studentToUpdate.setMarks(95.0);
                studentToUpdate.setDepartment("Computer Science & Engineering");
                studentDAO.updateStudent(studentToUpdate);
                
                StudentEntity updatedStudent = studentDAO.getStudentById(studentToUpdate.getId());
                if (updatedStudent != null) {
                    System.out.println("After Update: " + updatedStudent.getName() + " - Marks: " + updatedStudent.getMarks());
                    System.out.println("Updated Department: " + updatedStudent.getDepartment());
                }
            }
            
            // ===== DELETE Operation =====
            System.out.println("\n" + "-".repeat(80));
            System.out.println("🗑️ 5. DELETE Operation - Deleting Student");
            System.out.println("-".repeat(80));
            
            students = studentDAO.getStudents();
            if (students != null && !students.isEmpty()) {
                int lastStudentId = students.get(students.size() - 1).getId();
                System.out.println("Deleting student with ID: " + lastStudentId);
                studentDAO.deleteStudent(lastStudentId);
            }
            
            // ===== Final Read to confirm deletion =====
            System.out.println("\n" + "-".repeat(80));
            System.out.println("📊 6. Final Status - Remaining Students After Deletion");
            System.out.println("-".repeat(80));
            
            students = studentDAO.getStudents();
            if (students != null && !students.isEmpty()) {
                System.out.println("\n" + String.format("%-5s %-25s %-20s %-10s", "ID", "Name", "Department", "Marks"));
                System.out.println("-".repeat(80));
                for (StudentEntity student : students) {
                    System.out.println(String.format("%-5d %-25s %-20s %-10.2f", 
                        student.getId(), 
                        student.getName(), 
                        student.getDepartment(), 
                        student.getMarks()));
                }
            }
            
            // ===== Summary =====
            System.out.println("\n" + "=".repeat(80));
            System.out.println("✅ All CRUD Operations Completed Successfully!");
            System.out.println("=".repeat(80));
            System.out.println("\n📄 Operations Summary:");
            System.out.println("  ✓ CREATE: 3 students added to database");
            System.out.println("  ✓ READ: Retrieved all students and individual student by ID");
            System.out.println("  ✓ UPDATE: Modified student marks and department");
            System.out.println("  ✓ DELETE: Removed one student from database");
            System.out.println("\n🎯 Database Configuration:");
            System.out.println("  ✓ Database: spring_hibernate_demo");
            System.out.println("  ✓ User: root");
            System.out.println("  ✓ Dialect: MySQL8Dialect");
            System.out.println("  ✓ Connection URL: jdbc:mysql://localhost:3306/spring_hibernate_demo");
            System.out.println("\n" + "=".repeat(80));
            
        } catch (Exception e) {
            System.err.println("\n❌ Error during CRUD operations: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close SessionFactory
            StudentDAO.closeSessionFactory();
            System.out.println("\n✅ Hibernate Application Completed Successfully!\n");
        }
    }
}
