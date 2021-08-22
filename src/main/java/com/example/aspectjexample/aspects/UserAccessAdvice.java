package com.example.aspectjexample.aspects;

import com.example.aspectjexample.controllers.UserController;
import com.example.aspectjexample.dao.UserDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
public class UserAccessAdvice {

    public UserAccessAdvice(){

    }

    Logger log = LoggerFactory.getLogger(UserAccessAdvice.class);

    @Autowired
    UserDao userDao;

    //Defining the pointcut
    @Pointcut(value="execution(* com.example.aspectjexample.controllers.UserController.logoutUser(..)) || execution(* com.example.aspectjexample.controllers.UserController.loginUser(..))")
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
        if(methodName.equalsIgnoreCase("loginUser")){
            userDao.registerLogin((String)pjp.getArgs()[0]);
        } else{
//            userDao.registerLogout((String)pjp.getArgs()[0]);
        }
        return obj;
    }
}
