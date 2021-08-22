package com.example.aspectjexample.configurations;

import com.example.aspectjexample.aspects.UserAccessAdvice;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {

    @Bean
    public UserAccessAdvice userAccessAdvice() {
        UserAccessAdvice aspect = Aspects.aspectOf(UserAccessAdvice.class);
        return aspect;
    }
}
