package com.softwerk.practice.stage4;

import org.osgi.framework.BundleContext;

public class Command {
    private BundleContext bundleContext;

    public Command(BundleContext context) {
        this.bundleContext = context;
    }

    public void hello(){
        System.out.println("Hello, Stranger! If you want specific greeting, please write your name after command!");
    }

    public void hello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
