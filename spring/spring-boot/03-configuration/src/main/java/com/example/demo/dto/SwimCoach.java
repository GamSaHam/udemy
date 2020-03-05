package com.example.demo.dto;

import com.example.demo.services.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    private FortuneService fortuneService;

    public SwimCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String doSomething() {
        return "I'm a swim coache";
    }

    public String doFortuneService(){
        return fortuneService.getFortune();
    }


    public String getTeam() {
        return team;
    }

    public String getEmail() {
        return email;
    }
}
