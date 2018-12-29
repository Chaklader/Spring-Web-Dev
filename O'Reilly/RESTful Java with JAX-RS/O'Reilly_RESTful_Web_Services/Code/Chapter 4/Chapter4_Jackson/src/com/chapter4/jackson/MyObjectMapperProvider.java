package com.chapter4.jackson;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.Pair;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {

    final ObjectMapper defaultObjectMapper;
    final ObjectMapper userObjectMapper;

    public MyObjectMapperProvider() {
    	System.out.println("MyObjectMapperProvider()");
        defaultObjectMapper = createDefaultMapper();
        userObjectMapper = createUserObjectMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type) {

    	System.out.println("getContext(Class<?> type: " + (type == User.class?"User":"Default") + ")");

        if (type == User.class) {
            return userObjectMapper;
        } else {
            return defaultObjectMapper;
        }
    }

    private static ObjectMapper createUserObjectMapper() {

    	System.out.println("createUserObjectMapper()");
        Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
        ObjectMapper result = new ObjectMapper();

        result.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
        result.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
        result.setDeserializationConfig(result.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
        result.setSerializationConfig(result.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));

        return result;
    }

    private static ObjectMapper createDefaultMapper() {
    	System.out.println("createDefaultMapper()");
        ObjectMapper result = new ObjectMapper();
        result.configure(Feature.INDENT_OUTPUT, true);

        return result;
    }

    private static Pair createJaxbJacksonAnnotationIntrospector() {
    	System.out.println("createJaxbJacksonAnnotationIntrospector()");
        AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
        AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

        return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
    }
}