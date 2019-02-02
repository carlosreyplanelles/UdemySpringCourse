package hibernate.demo.unidirectional;

import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);
            if(instructor != null){
                session.delete(instructor);
                System.out.println( instructor +" deleted");
                session.getTransaction().commit();
            }
        } finally {
            session.close();
        }
    }

}

