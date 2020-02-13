package com.example.demo;

import com.example.demo.domain.Instructor.Instructor;
import com.example.demo.domain.Instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Test
    void unitTest(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        session.save(tempInstructor);

        session.getTransaction().commit();
    }

    @Test
    void deleteTest(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int theId = 1;

        Instructor tempInstrucotr = session.get(Instructor.class, theId);

        if(tempInstrucotr != null){
            System.out.println(tempInstrucotr);

            // Note: will ALSO delete associated "details object
            // because of CascadeType.ALL
             session.delete(tempInstrucotr);
            System.out.println("Delete it done!!");
        }


        System.out.println(tempInstrucotr);

        session.getTransaction().commit();
    }





}
