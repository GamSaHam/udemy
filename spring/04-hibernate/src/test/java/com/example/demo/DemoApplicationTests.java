package com.example.demo;

import com.example.demo.domain.student.Student;
import com.example.demo.domain.student.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void addStudentTest(){

        Student tempStudent1 = new Student("John","Doe","john@gmail.com");
        Student tempStudent2 = new Student("Mary","Public","mary@gmail.com");
        Student tempStudent3 = new Student("Bonita","Applebum","bonita@gmail.com");

        System.out.println("Saving the students...");
        studentRepository.save(tempStudent1);
        studentRepository.save(tempStudent2);
        studentRepository.save(tempStudent3);

    }

    @Test
    void getStudentEntityByIdTest(){

        Optional<Student> optional = studentRepository.findStudentById(5);

        optional.ifPresent(student ->{
            System.out.println(student.getId());
            System.out.println(student.getFirstName());
            System.out.println(student.getLastName());
            System.out.println(student.getEmail());
        });

    }

    @Test
    void printEntityManager(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Student> theStudents = session.createQuery("from Student").getResultList();

        for(Student student : theStudents){
            System.out.println(student);
        }

        theStudents = session.createQuery("from Student s where s.lastName='Doe'").list();

        for(Student student : theStudents){
            System.out.println(student);
        }

//        theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Daffy'").list();

        session.getTransaction().commit();
    }

    @Test
    void createQueryTest(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Student> theStudents = session.createQuery("from Student s where s.lastName='Doe' or s.firstName='Mary'").list();

        System.out.println("======================");
        for(Student student : theStudents){
            System.out.println(student);
        }
        System.out.println("======================");


        session.getTransaction().commit();

    }

    @Test
    void createQueryTest2(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Student> theStudents = session.createQuery("from Student s where s.email like '%gmail.com'").list();

        System.out.println("======================");
        for(Student student : theStudents){
            System.out.println(student);
        }
        System.out.println("======================");

        session.getTransaction().commit();
    }

    @Test
    void createQueryTest3(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        int studentId = 1;

        Student myStudent = session.get(Student.class, studentId);
        myStudent.setFirstName("Scooby");

        session.getTransaction().commit();
    }

    @Test
    void createQueryTest4(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.createQuery("update Student set email='foo@gmail.com' where firstName='John'").executeUpdate();

        session.getTransaction().commit();
    }

    @Test
    void deleteQueryTest(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        int studentId = 1;

        Student myStudent = session.get(Student.class, studentId);

        System.out.println("Deleting student: " + myStudent);
        // delete the student
        session.delete(myStudent);

        session.getTransaction().commit();
    }

    @Test
    void deleteQueryTest2(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }
        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("Deleting student id=4");
        session.createQuery("delete from Student where id=4").executeUpdate();

        session.getTransaction().commit();
    }




}
