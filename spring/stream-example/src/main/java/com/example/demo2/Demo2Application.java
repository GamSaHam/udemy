package com.example.demo2;

import com.example.demo2.dto.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {

        //객체 생성
        Employee[] arrayOfEmps = {
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(1, "Jeff Bezos", 100000.0),
                new Employee(1, "Jeff Bezos", 100000.0)
        };

        //스트림 객체 생성 방버
        Stream.of(arrayOfEmps);

        List<Employee> empList = Arrays.asList(arrayOfEmps);
        empList.stream();

        Stream.of(arrayOfEmps[0], arrayOfEmps[1], arrayOfEmps[2]);

        Stream.Builder<Employee> empStreamBuilder = Stream.builder();

        empStreamBuilder.accept(arrayOfEmps[0]);
        empStreamBuilder.accept(arrayOfEmps[1]);
        empStreamBuilder.accept(arrayOfEmps[2]);

        Stream<Employee> empStream = empStreamBuilder.build();

//        empList.stream().forEach(e-> e.salaryIncrement(10.0));

        List<String> names = Arrays.asList("jeong","pro", "jdk", "java");

        long count = 0;
        for(String name: names){
            if(name.contains("o")){
                count++;
            }
        }

        System.out.println("Count" + count);

        count = 0;
        count = names.stream().filter(x -> x.contains("o")).count();

        System.out.println("Stream Count"+count);

        SpringApplication.run(Demo2Application.class, args);
    }

}
