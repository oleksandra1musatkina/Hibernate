package sk.itsovy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.hibernate.demo.entity.Course;
import sk.itsovy.hibernate.demo.entity.Instructor;
import sk.itsovy.hibernate.demo.entity.InstructorDetail;
import sk.itsovy.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession(         );

        try {


            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}





