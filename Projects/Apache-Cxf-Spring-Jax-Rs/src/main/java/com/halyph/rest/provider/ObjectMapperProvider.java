package com.halyph.rest.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper objectMapper;

    public ObjectMapperProvider() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        //set up ISO 8601 date/time stamp format:
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.objectMapper.setDateFormat(df);
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {
        return this.objectMapper;
    }
}
