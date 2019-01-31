package hibernate.demo.unidirectional;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateInstructorDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Instructor instructor = new Instructor("Luis", "Perez", "email");
        InstructorDetail detail = new InstructorDetail("channel", "gaming");
        instructor.setInstructorDetail(detail);
        try {
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println( instructor +" saved");
        } finally {
            session.close();
            factory.close();
        }
    }

}

