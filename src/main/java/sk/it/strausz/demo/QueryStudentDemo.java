package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.strausz.entity.Student;

import java.util.List;

public class QueryStudentDemo {


    public static void main(String[] args) {



        SessionFactory factory = new Configuration()
                .configure("/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{



            session.beginTransaction();

            List<Student> students = session.createQuery("from Student ").getResultList();

            displayStudents(students);

            students = session.createQuery("from Student s where s.lastName='Doe' ").getResultList();

            System.out.println("\nLast name Doe:  ");
            displayStudents(students);

            students =
                    session.createQuery("from Student s where s.lastName = 'Doe' OR  s.firstName='Daffy'" )
                    .getResultList();

            System.out.println("\nLast name Doe or first name Daffy:  ");
            displayStudents(students);

            students =
                    session.createQuery("from Student s where  s.email LIKE " +
                            "'%gmail.com'").getResultList();


            System.out.println("\nEmail ends with gmail:  ");
            displayStudents(students);


            session.getTransaction().commit();

        }finally {
            factory.close();
        }



    }

    private static void displayStudents(List<Student> students) {
        for(Student temp : students){
            System.out.println(temp);
        }
    }
}
