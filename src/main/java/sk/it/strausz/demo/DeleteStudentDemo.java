package sk.it.strausz.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.strausz.entity.Student;

public class DeleteStudentDemo {

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
//
//            System.out.println(myStudent + " deleted");
//            session.delete(myStudent);

            session.createQuery("delete from Student  where  id=2").executeUpdate();


            session.getTransaction().commit();





        }finally {
            factory.close();
        }



    }

}
