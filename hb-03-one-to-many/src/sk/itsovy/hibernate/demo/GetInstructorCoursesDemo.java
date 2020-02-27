package sk.itsovy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.hibernate.demo.entity.Course;
import sk.itsovy.hibernate.demo.entity.Instructor;
import sk.itsovy.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
/*
            Instructor tempInstructor = new Instructor("Chad",
                    "Darby", "darby@luv2code.com"
            );
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "luv2code.com/youtube", "Luv 2 code"
            );

            tempInstructor.setInstructorDetail(tempInstructorDetail);
*/


            session.beginTransaction();
            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Instructor: " + tempInstructor);

            // get courses for the instructor
            System.out.println("Courses: " + tempInstructor.getCourses());
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}





