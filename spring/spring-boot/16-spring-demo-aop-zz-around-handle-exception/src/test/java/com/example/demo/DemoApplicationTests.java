package com.example.demo;

import com.example.demo.config.DemoConfig;
import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.model.Account;
import com.example.demo.service.TrafficFortuneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    private static Logger logger = Logger.getLogger(DemoApplicationTests.class.getName());


    @Test
    void aroundWithLoggerDemoTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);


        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("Main Program: AroundDemoApp");

        logger.info("Calling getFortune");

        boolean tripWire = true;
        String data = trafficFortuneService.getFortune(tripWire);

        logger.info("My fortune is: "+ data);

        logger.info("Finished");

        context.close();

    }

 





}
