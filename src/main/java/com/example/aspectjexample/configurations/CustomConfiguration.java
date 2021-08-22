package com.example.aspectjexample.configurations;

import com.example.aspectjexample.aspects.UserAccessAdvice;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@EnableAspectJAutoProxy
@ImportResource("classpath:beans.xml")
public class CustomConfiguration {

//    @Bean
//    public UserAccessAdvice userAccessAdvice() {
//        UserAccessAdvice aspect = Aspects.aspectOf(UserAccessAdvice.class);
//        return aspect;
//    }

//    @Bean
//    public ExceptionAspectHandler exceptionAspectHandler()
//    {
//        return Aspects.aspectOf( ExceptionAspectHandler.class );
//    }
//
}
