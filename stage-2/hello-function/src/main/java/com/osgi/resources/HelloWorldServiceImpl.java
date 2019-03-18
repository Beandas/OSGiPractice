package com.osgi.resources;


import com.osgi.resources.HelloWorldService;

/**
 * Created by Дарья on 02.03.2019.
 */
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public void hello() {
        System.out.println("Hello OSGI World!");
    }
}
