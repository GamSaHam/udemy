package com.example.demo;

import com.example.demo.domain.Instructor.*;
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

        Course course = new Course("Pacman - How to Score One Million Points");

        System.out.println("Saving the course...");
        session.save(course);
        System.out.println("Saved the course:" + course);

        // create the students
        Student student1 = new Student("Join", "Deo", "john@test.com");
        Student student2 = new Student("Mary", "Public", "mary@test.com");

        course.addStudent(student1);
        course.addStudent(student2);

        System.out.println("Saving the students...");
        session.save(student1);
        session.save(student2);
        System.out.println("Saved the students:" + course.getStudents());


        session.getTransaction().commit();
    }
    @Test
    void addOtherCourses(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // get the student mary from database
        int id = 2;

        Student student = session.get(Student.class, id);

        System.out.println("Loaded student: " + student);
        System.out.println("Courses: " + student.getCourses());

        // create more courses
        Course course1 = new Course("Rubik's Cube - How to Speed Cube");
        Course course2 = new Course("Atari 2600 - Game Development");

        // add student to courses
        course1.addStudent(student);
        course2.addStudent(student);

        // save the courses
        System.out.println("Saving the courses ...");
        session.save(course1);
        session.save(course2);
        System.out.println("Saved the courses");

        session.getTransaction().commit();
    }

    @Test
    void printCoursesByStudentId(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // get the student mary from database
        int id = 1;

        Student student = session.get(Student.class, id);

        System.out.println("Loaded student: " + student);
        System.out.println("Courses: " + student.getCourses());

        session.getTransaction().commit();
    }

    @Test
    void deletePacmanCourseDemo(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();


        // get the pacman course from db
        int courseId = 10;

        Course course = session.get(Course.class, courseId);

        System.out.println("Deleting course: "+ course);

        session.delete(course);

        session.getTransaction().commit();
    }
    @Test
    void deleteMaryStudentDemo(){

        if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
            throw new NullPointerException("factory is not a hibernate factory");
        }


        SessionFactory sessionFactory =  entityManagerFactory.unwrap(SessionFactory.class);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        // get the student mary from database
        int id = 2;

        Student student = session.get(Student.class, id);

        System.out.println("Loaded student: " + student);
        System.out.println("Courses: " + student.getCourses());

        // delete student
        System.out.println("Delete student: " + student);
        session.delete(student);


        session.getTransaction().commit();
    }






}
