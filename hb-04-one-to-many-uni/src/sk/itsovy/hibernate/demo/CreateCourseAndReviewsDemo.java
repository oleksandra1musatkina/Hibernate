package sk.itsovy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.hibernate.demo.entity.Course;
import sk.itsovy.hibernate.demo.entity.Instructor;
import sk.itsovy.hibernate.demo.entity.InstructorDetail;
import sk.itsovy.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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

            Course tempCourse = new Course("Pacman - How To Score One Million Points");

            tempCourse.addReview(new Review("Great course ... loved it!"));
            tempCourse.addReview(new Review("Cool course, job well done"));
            tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

            System.out.println("Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}





