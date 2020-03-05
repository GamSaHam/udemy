package com.example.demo;

import com.example.demo.domain.Instructor.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Test
    public void unitTest(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        //TODO

        int theId = 1;
        Instructor tempInstructor = session.get(Instructor.class, theId);

        System.out.println("Instrucotr: " + tempInstructor);

        System.out.println("Courses: " + tempInstructor.getCourses());

        session.getTransaction().commit();

        System.out.println("Courses: " + tempInstructor.getCourses());

    }

    @Test
    public void unitTest2(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        int theId = 1;

        Query<Instructor> query = session.createQuery("select i from Instructor  i where i.id = :theIInstructor", Instructor.class);

        query.setParameter("theIInstructor", theId);

        Instructor tempInstructor = query.getSingleResult();

        System.out.println("Instructor" + tempInstructor);


        session.beginTransaction();

    }











}
