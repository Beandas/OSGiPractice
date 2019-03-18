package com.softwerk.practice.stage4;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


import java.util.Dictionary;
import java.util.Hashtable;

public class HelloCommandActivator implements BundleActivator {

    public void start(BundleContext bundleContext) {
        bundleContext.registerService(Command.class.getName(), new Command(bundleContext), getProps());
    }

    public void stop(BundleContext bundleContext) {
        //Nothing to do
    }

    private Dictionary<String, String> getProps() {
        Hashtable<String, String> props = new Hashtable<String, String>();
        props.put("osgi.command.scope", "practice");
        props.put("osgi.command.function", "hello");
        return props;
    }
}
