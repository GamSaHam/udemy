package com.example.demo.dto;

import com.example.demo.services.FortuneService;
import com.example.demo.services.HappyFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "tennisCoach")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService2")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(FortuneService fortuneService){
//        this.fortuneService = fortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    public String getDailyFortune(){
            return fortuneService.getFortune();
    }


}
