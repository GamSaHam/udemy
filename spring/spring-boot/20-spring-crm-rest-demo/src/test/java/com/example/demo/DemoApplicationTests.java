package com.example.demo;

import com.example.demo.domain.Instructor.Course;
import com.example.demo.domain.Instructor.Instructor;
import com.example.demo.domain.Instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManagerFactory;

import java.util.List;

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

    @Test
    public void testAddCourse(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int theId = 1;

        Instructor instructor = session.get(Instructor.class, theId);

        Course course1 = new Course("Air Guitar - The Ultimate Guide");
        Course course2 = new Course("The Pinball Masterclass");

        instructor.add(course1);
        instructor.add(course2);

        session.save(course1);
        session.save(course2);

        session.getTransaction().commit();
    }

    @Test
    public void testPrintAllCourses(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int theId = 1;

        Instructor instructor = session.get(Instructor.class, theId);

        List<Course> coursesList = instructor.getCourses();

        for(Course course : coursesList){
            System.out.println(course.getTitle());
        }


        session.getTransaction().commit();
    }

    @Test
    void testDeleteCourse(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        Course course1 = session.get(Course.class, 10);
        Course course2 = session.get(Course.class, 11);


        session.delete(course1);
        session.delete(course2);

        session.getTransaction().commit();

    }

    @Test
    public void testFetchType(){
        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        int theId = 1;
        Instructor instructor = session.get(Instructor.class, theId);

        System.out.println("instructor:" + instructor);

        session.getTransaction().commit();
    }








}
