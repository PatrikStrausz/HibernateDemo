package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.strausz.entity.Instructor;
import sk.it.strausz.entity.InstructorDetail;
import sk.it.strausz.entity.Student;

public class CreateDemo {

    public static void main(String[] args) {



        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Instructor instructor = new Instructor("Chad", "Darby","@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("youtube.com","coding");
            session.beginTransaction();

            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }


}
