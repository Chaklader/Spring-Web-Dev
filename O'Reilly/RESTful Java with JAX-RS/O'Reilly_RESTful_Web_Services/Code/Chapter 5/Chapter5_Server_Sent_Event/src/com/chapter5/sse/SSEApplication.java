package com.chapter5.sse;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("services")
public class SSEApplication extends ResourceConfig {
    public SSEApplication() {
        super(SSEResource.class, SseFeature.class);
    }
}
