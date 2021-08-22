package com.example.aspectjexample.aspects;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAccessAdvice {

    Logger log = LoggerFactory.getLogger(UserAccessAdvice.class);

    //Defining the pointcut
    @Pointcut(value="execution(* com.example.aspectjexample.controllers.UserController.loginUser(..))")
    public void logoutPointcut(){

    }

    @Around("logoutPointcut()")
    public Object logoutLogger(ProceedingJoinPoint pjp) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        String methodName = pjp.getSignature().getName();
        log.info("Method about to be invoked : {}", methodName);
        Object obj = pjp.proceed();
        log.info("After the method was invoked, got return value as: {}",
                objectMapper.writeValueAsString(obj));
        return obj;
    }
}
