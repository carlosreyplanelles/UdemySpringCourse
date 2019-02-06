package hibernate.demo;

import hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForTestDemo {

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
            int id = 2;
            Student student = session.get(Student.class, id);
            System.out.println("Student courses: "+ student.getCourses());
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }
}

