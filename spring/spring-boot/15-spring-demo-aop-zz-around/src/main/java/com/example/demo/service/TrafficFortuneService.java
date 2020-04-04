package com.example.demo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

    public String getFortune()  {

        // simulate a delay


        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            System.out.println("Error : TimeUnit seconds function");
        }

        // return a fortune

        return "Expect heavy traffic this morning";

    }


    public String getFortune(boolean tripWire) {

        if(tripWire) {
            throw new RuntimeException("Major accident! Highway is closed1");
        }

        return getFortune();
    }



}
