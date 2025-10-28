package com.springhibernate;

import com.springhibernate.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {
    
    private static SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(StudentEntity.class)
                    .buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Error creating SessionFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // CREATE - Add a new student
    public void addStudent(StudentEntity student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            System.out.println("✅ Student added successfully: " + student.getName());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("❌ Error adding student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // READ - Get all students
    public List<StudentEntity> getStudents() {
        try (Session session = sessionFactory.openSession()) {
            Query<StudentEntity> query = session.createQuery("FROM StudentEntity", StudentEntity.class);
            List<StudentEntity> students = query.list();
            System.out.println("\n📚 Retrieved " + students.size() + " student(s) from database");
            return students;
        } catch (Exception e) {
            System.err.println("❌ Error retrieving students: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    // READ - Get student by ID
    public StudentEntity getStudentById(int id) {
        try (Session session = sessionFactory.openSession()) {
            StudentEntity student = session.get(StudentEntity.class, id);
            if (student != null) {
                System.out.println("✅ Student found: " + student.getName());
            } else {
                System.out.println("⚠️ No student found with ID: " + id);
            }
            return student;
        } catch (Exception e) {
            System.err.println("❌ Error retrieving student: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    // UPDATE - Update student details
    public void updateStudent(StudentEntity student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
            System.out.println("✅ Student updated successfully: " + student.getName());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("❌ Error updating student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // DELETE - Delete student by ID
    public void deleteStudent(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            StudentEntity student = session.get(StudentEntity.class, id);
            if (student != null) {
                session.delete(student);
                System.out.println("✅ Student deleted successfully: " + student.getName());
            } else {
                System.out.println("⚠️ No student found with ID: " + id);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.err.println("❌ Error deleting student: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // Close SessionFactory
    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
            System.out.println("\n🔒 SessionFactory closed successfully");
        }
    }
}
