package com.example;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages=
		{"com.example.application.config", 
		 "com.example.application.controller", 
		 "com.example.domain.service", 
		 "com.example.domain.domain"}, 
   lazyInit=true)

public class DemoApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		//listBeans(ctx);
	}
	
	
	private static void listBeans(ApplicationContext ctx){
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }		
	}
}
