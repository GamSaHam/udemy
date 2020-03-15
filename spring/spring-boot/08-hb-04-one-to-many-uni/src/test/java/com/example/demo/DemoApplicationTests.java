package com.example.demo;

import com.example.demo.domain.Instructor.Course;
import com.example.demo.domain.Instructor.Instructor;
import com.example.demo.domain.Instructor.InstructorDetail;
import com.example.demo.domain.Instructor.Review;
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
    void addReviewAndCourses(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // create a course
        Course tempCourse = new Course("Pacman - Hoe to Socre One Million Points");

        // add some reviews
        tempCourse.addReview(new Review("Greate course ... loved it!"));
        tempCourse.addReview(new Review("Cool course ... job well done"));
        tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));

        System.out.println("Saving the course");
        System.out.println(tempCourse);
        System.out.println(tempCourse.getReviews());

        session.save(tempCourse);

        // save the course ... and leverage the cascade all :-)




        session.getTransaction().commit();
    }

    @Test
    void printReviewAndCourses(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // get the course
        int id = 10;
        Course course = session.get(Course.class, id);

        // print the course
        System.out.println(course);

        // print the course
        System.out.println(course.getReviews()); //



        session.getTransaction().commit();
    }
    @Test
    void deleteReviewAndCourses(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // get the course
        int id = 10;
        Course course = session.get(Course.class, id);

        // print the course
        System.out.println("Deleting the course ...");
        System.out.println(course);

        session.delete(course);

        session.getTransaction().commit();
    }









}
