package hibernate.demo;

import hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateCoursesStudentsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            System.out.println("Creating testCourse...");
            Course course = new Course("Course1");
            session.save(course);
            System.out.println("Course created: "+course);
            System.out.println("Creating student...");
            Student testStudent = new Student ("John", "Test", "john@test.com");
            course.addStudent(testStudent);
            session.save(testStudent);
            System.out.println("Student created: "+testStudent);
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

