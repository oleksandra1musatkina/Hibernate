package sk.itsovy.hibernate.demo;

import sk.itsovy.hibernate.demo.entity.Instructor;
import sk.itsovy.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
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
            Instructor tempInstructor = new Instructor("Madhu",
                    "Patel", "madhu@luv2code.com"
            );
            InstructorDetail tempInstructorDetail = new InstructorDetail(
                    "youtube.com", "Guitar"
            );

            tempInstructor.setInstructorDetail(tempInstructorDetail);


            session.beginTransaction();
            System.out.println("savind instructor" + tempInstructor);
            session.save(tempInstructor);
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}





