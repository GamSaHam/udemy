package com.example.demo;

import com.example.demo.dto.Coach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


		Coach theCoach = context.getBean("myCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkOut());

		context.close();

		SpringApplication.run(DemoApplication.class, args);
	}

}
