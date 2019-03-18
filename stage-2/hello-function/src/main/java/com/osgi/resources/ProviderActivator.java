package com.osgi.resources;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ProviderActivator implements BundleActivator {
    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context){
        registration = context.registerService(HelloWorldService.class.getName(),
                new HelloWorldServiceImpl(), null);
    }

    @Override
    public void stop(BundleContext context){
        registration.unregister();
    }
}
