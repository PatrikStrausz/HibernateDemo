package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.strausz.entity.Student;

public class ReadStudentDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            Student tempStudent1 = new Student("Daffy", "Duck", "daffy@gmail.com");


            session.beginTransaction();

            session.save(tempStudent1);

            session = factory.getCurrentSession();


            System.out.println("\nGetting student with id: " + tempStudent1.getId());

            Student myStudent = session.get(Student.class, tempStudent1.getId());

            System.out.println("Student" +myStudent);


            session.getTransaction().commit();
        }finally {
            factory.close();
        }




    }

}
