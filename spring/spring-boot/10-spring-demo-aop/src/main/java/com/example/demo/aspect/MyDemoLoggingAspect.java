package com.example.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // This is where we add all of out relted advices for logging
    // Let's start with an @Before advice
    // @Before("execution(public void add*())") // @Before([Pointcut expression])
    // @Before("execution(* add*())") // @Before([Pointcut expression])
    // @Before("execution(* add*(..))") // @Before([Pointcut expression])
    @Before("execution(* com.example.demo.dao.*.*(..))") // Returen Type, Package, Class, Method, Params
    public void beforeAddAccountAdvice(){
        System.out.println("======>>> Executing @Before advice on addAccount()");
    }

    // Match on method names
    //@Before("execution(public void com.example.com.dao.AccountDAO.addAcount())")
    // Modifier, Reture type, Method

    // Match on method names ( using wildcards)
    //@Before("execution(public void add*())")
    // Modifier, Return type, Mdethod

    //@Before("execution(* * processCreditCard*())")
    // any Modifier, any Return Type, any Method start with processCreditCard prefix

    // Modifier is optional .. so you don't have to list it

    // ..

    




}






