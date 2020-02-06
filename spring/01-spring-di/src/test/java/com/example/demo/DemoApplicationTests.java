package com.example.demo;

import com.example.demo.dto.BaseballCoach;
import com.example.demo.dto.Coach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.reactive.context.GenericReactiveWebApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoad() {


        GenericXmlApplicationContext ac=new GenericXmlApplicationContext("applicationContext.xml");

        BaseballCoach baseballCoach = (BaseballCoach) ac.getBean("myCoach");

//        System.out.println(baseballCoach.saySomething());
//       ((baseballCoach.getDailyWorkout());

        assertThat(baseballCoach.getDailyWorkout(), is("Today is your luck day!"));


        BaseballCoach baseballCoach2 = (BaseballCoach) ac.getBean("myCoach2");

        assertThat(baseballCoach2.getDailyWorkout(), is("Today is your luck day!"));
        assertThat(baseballCoach2.getEmailAddress(), is("test@test.com"));

        ac.close();
    }

    @Test
    void testSingletonBean(){
        GenericXmlApplicationContext context=new GenericXmlApplicationContext("applicationContext.xml");

        BaseballCoach theCoach = context.getBean("myCoach", BaseballCoach.class);
        BaseballCoach alphaCoach = context.getBean("myCoach", BaseballCoach.class);

        theCoach.setEmailAddress("test2@test.com");

        assertThat(theCoach.getEmailAddress(), is(alphaCoach.getEmailAddress()));

    }

    @Test
    void testPrototypeBean(){
        GenericXmlApplicationContext context=new GenericXmlApplicationContext("applicationContext.xml");

        BaseballCoach theCoach = context.getBean("myCoachPrototype", BaseballCoach.class);
        BaseballCoach alphaCoach = context.getBean("myCoachPrototype", BaseballCoach.class);

        alphaCoach.setEmailAddress("test2@test.com");


//        System.out.println(theCoach.getEmailAddress());
//        System.out.println(alphaCoach.getEmailAddress());

        assertThat(theCoach.getEmailAddress(), is("test@test.com"));
        assertThat(alphaCoach.getEmailAddress(), is("test2@test.com"));
    }

    @Test
    void testBeanInitMethod(){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        BaseballCoach baseballCoach = context.getBean("myCoach3", BaseballCoach.class);


        context.close();

    }


}




