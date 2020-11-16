package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import sk.it.strausz.entity.Student;

public class CreateStudentDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("D:\\IntelliJ\\HibernateDemo\\src\\hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Student tempStudent = new Student("Paul", "Wall", "paul@gmail.com");

            session.beginTransaction();

            session.save(tempStudent);

            session.getTransaction().commit();
        }finally {
            factory.close();
        }

    }
}
