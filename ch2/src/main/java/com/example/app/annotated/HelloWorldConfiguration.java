package com.example.app.annotated;

import com.example.app.decoupled.HelloWorldMessageProvider;
import com.example.app.decoupled.MessageProvider;
import com.example.app.decoupled.MessageRenderer;
import com.example.app.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    @Bean
    public MessageRenderer renderer() {
        MessageRenderer mr = new StandardOutMessageRenderer();
        mr.setMessageProvider(provider());
        return mr;
    }

    @Bean
    @Scope("prototype")
    public MessageRenderer rendererPrototype() {
        MessageRenderer mr = new StandardOutMessageRenderer();
        mr.setMessageProvider(provider());
        return mr;
    }
}
