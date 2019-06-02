package com.example.app;

import com.example.app.annotated.HelloWorldConfiguration;
import com.example.app.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWorldAnnotated {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(
                HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();

        // each object is the same (singleton)
        System.out.println("mr singleton 1" + mr.toString());
        mr = ctx.getBean("renderer", MessageRenderer.class);
        System.out.println("mr singleton 2" + mr.toString());
        mr = ctx.getBean("renderer", MessageRenderer.class);
        System.out.println("mr singleton 3" + mr.toString());
        mr = ctx.getBean("renderer", MessageRenderer.class);

        // each object is different (new)
        mr = ctx.getBean("rendererPrototype", MessageRenderer.class);
        System.out.println("mr rendererPrototype 1" + mr.toString());
        mr = ctx.getBean("rendererPrototype", MessageRenderer.class);
        System.out.println("mr rendererPrototype 2" + mr.toString());
        mr = ctx.getBean("rendererPrototype", MessageRenderer.class);
        System.out.println("mr rendererPrototype 3" + mr.toString());
    }
}
