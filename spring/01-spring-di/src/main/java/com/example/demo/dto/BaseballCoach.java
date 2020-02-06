package com.example.demo.dto;

import com.example.demo.service.FortuneService;
import com.example.demo.service.HappyFortuneService;

public class BaseballCoach implements Coach {

    private String emailAddress;
    private FortuneService fortuneService;

    public void setFurtuneService(HappyFortuneService furtuneService) {
        this.fortuneService = furtuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress(){
        return emailAddress;
    }

    public BaseballCoach(){

    }

    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    public String getDailyWorkout(){
        return fortuneService.getFortune();
    }

    @Override
    public String saySomething() {
        return "I'm a BasballCoach";
    }

    // add an init method
    public void doMyStartupStuff(){
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    // add a destory method
    public void doMyCleanupStuff(){
        System.out.println("TrackCoach: inside method doMyCleanupStuff");
    }



}
