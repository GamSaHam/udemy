package com.example.demo.dto;

import org.springframework.stereotype.Component;

@Component(value = "tennisCoach")
public class TennisCoach implements Coach{
    @Override
    public String doSomething() {
        return "I'm a tennis coache";
    }
}
