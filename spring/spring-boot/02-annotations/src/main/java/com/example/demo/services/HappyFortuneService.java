package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class HappyFortuneService implements FortuneService{

    private String fortuneName;

    public void setFortuneName(String fortuneName){
        this.fortuneName = fortuneName;
    }

    @Override
    public String getFortune() {
        return "Today is your "+this.fortuneName+"luck day!";
    }
}



