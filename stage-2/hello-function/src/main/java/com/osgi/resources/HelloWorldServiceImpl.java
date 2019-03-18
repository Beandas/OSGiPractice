package com.osgi.resources;


import com.osgi.resources.HelloWorldService;

public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void hello() {
        System.out.println("Hello OSGI World!");
    }
}
