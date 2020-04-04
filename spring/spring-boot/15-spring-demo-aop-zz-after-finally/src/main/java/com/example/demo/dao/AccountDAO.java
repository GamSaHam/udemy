package com.example.demo.dao;

import com.example.demo.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new mehtod : findAccounts()

    public List<Account> findAccounts(){
        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account account = new Account("John", "Silver");
        Account account2 = new Account("Madhu", "Platium");
        Account account3 = new Account("Luca", "Gold");

        myAccounts.add(account);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;
    }


    public void addAccount(Account account, boolean isVip){
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ":  in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}


