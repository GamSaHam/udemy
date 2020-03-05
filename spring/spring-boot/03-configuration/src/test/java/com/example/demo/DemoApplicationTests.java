package com.example.demo;

import com.example.demo.config.SportConfig;
import com.example.demo.dto.SwimCoach;
import com.example.demo.dto.TennisCoach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);

        assertThat(tennisCoach.doSomething(), is("I'm a tennis coache"));


        context.close();
    }

    @Test
    void contextLoad2(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);

        assertThat(swimCoach.doFortuneService(), is("Good luck!"));

        assertThat(swimCoach.getEmail(), is("myeasycoach@luv2.code.com"));
        assertThat(swimCoach.getTeam(), is("Awesome Java Coders"));

        context.close();

    }

}
