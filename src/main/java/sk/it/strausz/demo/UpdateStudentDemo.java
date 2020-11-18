package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.strausz.entity.Student;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            int studentId = 1;

            session = factory.getCurrentSession();
            session.beginTransaction();




            Student myStudent = session.get(Student.class, studentId);

            myStudent.setFirstName("Scooby");

            System.out.println("Student" +myStudent);


            session.getTransaction().commit();


            session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Student  set email='foo@gmail.com'")
            .executeUpdate();

            session.getTransaction().commit();



        }finally {
            factory.close();
        }



    }
}
