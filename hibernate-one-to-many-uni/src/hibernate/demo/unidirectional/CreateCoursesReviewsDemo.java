package hibernate.demo.unidirectional;

import hibernate.entity.Course;
import hibernate.entity.Instructor;
import hibernate.entity.InstructorDetail;
import hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CreateCoursesReviewsDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Course course = new Course("Course1");
            Review review = new Review("Review");
            course.addReview(review);
            session.save(course);
            List<Review> reviews = course.getReviews();
            System.out.println(course);
            reviews.stream().forEach((r)->
                    System.out.println(r));
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

}

