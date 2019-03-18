package com.osgi.bundle;


import com.osgi.resources.HelloWorldService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Дарья on 15.03.2019.
 */
public class HelloWorldConsumer implements ActionListener {
    private final HelloWorldService service;
    private final Timer timer;

    public HelloWorldConsumer(HelloWorldService service) {
        super();

        this.service = service;

        timer = new Timer(1000, this);
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        service.hello();
    }
}
