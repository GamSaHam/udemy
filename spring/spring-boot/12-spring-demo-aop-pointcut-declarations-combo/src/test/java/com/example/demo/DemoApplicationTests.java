package com.example.demo;

import com.example.demo.config.DemoConfig;
import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.model.Account;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {


    @Test
    void addReviewAndCourses() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        Account account = new Account();
        accountDAO.addAccount(account, true);
        accountDAO.doWork();

        // call the account/setter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        // call the membership business method
        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();


        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addSillyMember();
        membershipDAO.goToSleep();


        context.close();
    }





}
