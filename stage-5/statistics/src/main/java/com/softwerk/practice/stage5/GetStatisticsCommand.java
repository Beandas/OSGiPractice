package com.softwerk.practice.stage5;


import org.apache.felix.service.command.CommandProcessor;
import org.osgi.service.component.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

@Component(
        service = GetStatisticsCommand.class,
        immediate = true,
        property = {
            CommandProcessor.COMMAND_SCOPE + ":String=news",
            CommandProcessor.COMMAND_FUNCTION + ":String=stats"
        }
)
public class GetStatisticsCommand {

    Map<String, MediaGrabber> MediaGrabberMap = new HashMap<String, MediaGrabber>();

    @Reference(
            service = MediaGrabber.class,
            cardinality = ReferenceCardinality.MULTIPLE,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unbinder"
    )
    public void binder(MediaGrabber MediaGrabber) {
        System.out.println(MediaGrabber.getMediaName());
        MediaGrabberMap.put(MediaGrabber.getMediaName(), MediaGrabber);
    }

    public void unbinder(MediaGrabber MediaGrabber) {
        System.out.println("Unbind " + MediaGrabber.getMediaName());
        MediaGrabberMap.remove(MediaGrabber.getMediaName());
    }

    public void stats() {
        System.out.println("Expected \"news:stats <media_name>\"");
        System.out.println("<media_name> can be: " + MediaGrabberMap.keySet().stream().collect(joining(", ")));
    }

    public void stats(String mediaName) {
        if (MediaGrabberMap.containsKey(mediaName)) {
            System.out.println(MediaGrabberMap.get(mediaName).getTopWords());
        } else {
            System.out.println("<media_name> can be: " + MediaGrabberMap.keySet().stream().collect(joining(", ")));
        }
    }
}
