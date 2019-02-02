package hibernate.demo.unidirectional;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, 1);

            Course course1 = new Course("Course1");
            Course course2 = new Course("Course2");

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

}

