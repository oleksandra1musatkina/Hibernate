package sk.itsovy.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.itsovy.hibernate.demo.entity.Course;
import sk.itsovy.hibernate.demo.entity.Instructor;
import sk.itsovy.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession(         );

        try {


            session.beginTransaction();
            Instructor  temominstructor = session.get(Instructor.class,1);
Course tempCourse1=new Course("Guitare");
Course tempCourse2=new Course("Pinball");
temominstructor.add(tempCourse1);
temominstructor.add(tempCourse2);
session.save(tempCourse1);
session.save(tempCourse2);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}





