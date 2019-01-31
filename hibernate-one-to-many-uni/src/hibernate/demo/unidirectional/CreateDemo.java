package hibernate.demo.unidirectional;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        Instructor instructor = new Instructor("Carlos", "Rey", "email");
        InstructorDetail detail = new InstructorDetail("channel", "gaming");
        instructor.setInstructorDetail(detail);
        try {
            session.beginTransaction();
            session.save(instructor);
            session.getTransaction().commit();
            System.out.println( instructor +" saved");
        } finally {
            session.close();
        }
    }

}

