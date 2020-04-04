package com.example.demo.aspect;


import com.example.demo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method

    @AfterReturning(
            pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
            returning ="result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n========> Executing @AfterReturning on method:"+ method);

        // print ot the results of the method call
        System.out.println("\n========> result is:" + result);

        convertAccountNamesToUpperCase(result);

        System.out.println("\n========> result is:" + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {


        result.stream().forEach(account -> {

            String upperName = account.getName().toUpperCase();

            account.setName(upperName);
        });


    }

    //

    @Before("com.example.demo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("======>>> Executing @Before advice on method");


    }


}






