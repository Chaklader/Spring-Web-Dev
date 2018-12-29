package com.chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

@Provider
@Consumes(Person.PERSON_MIME_TYPE)
public class PersonReader implements MessageBodyReader<Person> {

    @Override
    public boolean isReadable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Person.class.isAssignableFrom(type);
    }

    @Override
    public Person readFrom(Class<Person> type,
                Type type1,
                Annotation[] antns,
                MediaType mt, MultivaluedMap<String, String> mm,
                InputStream in) throws IOException, WebApplicationException {
        try {
            ObjectInputStream ois = new ObjectInputStream(in);
            return (Person)ois.readObject();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}