package com.softwerk.practice.stage3;

import org.osgi.service.component.annotations.*;

@Component
public class HelloConsumer {

    private HelloWorldService helloWorldService;

    @Reference(
            service = HelloWorldService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            unbind = "unbinder"
    )
    protected void setGreeter(HelloWorldService hello) {
        this.helloWorldService = hello;
    }

    @Activate
    protected void onActivate() {
        helloWorldService.hello();
    }

    protected void unbinder(HelloWorldService hello) {
        this.helloWorldService = null;
    }

}
