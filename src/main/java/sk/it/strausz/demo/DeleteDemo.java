package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.strausz.entity.Instructor;
import sk.it.strausz.entity.InstructorDetail;

public class DeleteDemo {
    public static void main(String[] args) {



        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();

            Instructor instructor =session.get(Instructor.class, 1);

            if(instructor != null){

                session.delete(instructor);
            }


            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
