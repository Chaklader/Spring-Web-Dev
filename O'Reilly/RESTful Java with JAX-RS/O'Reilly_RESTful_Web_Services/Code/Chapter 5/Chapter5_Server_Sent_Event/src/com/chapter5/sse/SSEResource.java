package com.chapter5.sse;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

@Path("sseResource")
public class SSEResource {
    private static final SseBroadcaster BROADCASTER = new SseBroadcaster();

    @GET
    @Path("sseEvents")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getConnection() {
    	System.out.println("itemEvents().... ");
        final EventOutput eventOutput = new EventOutput();
        BROADCASTER.add(eventOutput);
        return eventOutput;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String post(@FormParam("name") String name) {
    	System.out.println("name: " + name);
        BROADCASTER.broadcast(new OutboundEvent.Builder().data(String.class, name).build());
        
        return name + " Added Successfully!!!";
    }
}
