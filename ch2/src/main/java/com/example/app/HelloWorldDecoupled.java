package com.example.app;

import com.example.app.annotated.HelloWorldConfiguration;
import com.example.app.decoupled.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldDecoupled {

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
