package com.softwerk.practice.stage3;

import org.osgi.service.component.annotations.*;

@Component(
        service = HelloWorldService.class,
        immediate = true
)
public class HelloWorldServiceImpl implements HelloWorldService {
    public void hello() {
        System.out.println("Hello World!");
    }
}
