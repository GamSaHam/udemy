package com.example.demo.dto;

import com.example.demo.services.FortuneService;
import com.example.demo.services.HappyFortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value = "tennisCoach")
@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("happyFortuneService")
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

    // define my init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> TenisCoach: inside of doMyStartupStuff()");

    }

    // define my destory method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println(">> TenisCoach: inside of doMyCleanupStuff()");
    }


}
