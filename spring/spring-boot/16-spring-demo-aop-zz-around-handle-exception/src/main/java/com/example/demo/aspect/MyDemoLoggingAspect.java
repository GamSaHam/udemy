package com.example.demo.aspect;


import com.example.demo.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.example.demo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("=======>>> Executing @Around on method: "+ method);

        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        long duration = end - begin;
        logger.info("=======> Duration "+ duration / 1000.0 + " seconds");

        return result;
    }


    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* com.example.demo.dao.AccountDAO.findAccounts(..))",
            returning ="result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info("========> Executing @AfterReturning on method:"+ method);

        // print ot the results of the method call
        logger.info("========> result is:" + result);

        convertAccountNamesToUpperCase(result);

        logger.info("========> result is:" + result);

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
        logger.info("======>>> Executing @Before advice on method");


    }


}






