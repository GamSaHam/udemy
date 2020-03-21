package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addSillyMember(){

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");

    }
}
