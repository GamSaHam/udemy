package com.example.demo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.example.demo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.example.demo.dao.*.get*(..))")
    private void getter() {}

    @Pointcut("execution(* com.example.demo.dao.*.set*(..))")
    private void setter() {}

    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice(){
        System.out.println("======>>> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("======>>> Performing API analytics");
    }




}






