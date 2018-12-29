package com.chapter3;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(Person.PERSON_MIME_TYPE)
public class PersonWriter implements MessageBodyWriter<Person> {

    @Override
    public boolean isWriteable(Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        return Person.class.isAssignableFrom(type);
    }

    @Override
    public long getSize(Person t, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
        // As of JAX-RS 2.0, the method has been deprecated and the
        // value returned by the method is ignored by a JAX-RS runtime.
        // All MessageBodyWriter implementations are advised to return -1 from
        // the method.
        
        return -1;
    }

    @Override
    public void writeTo(Person t,
                Class<?> type,
                Type type1,
                Annotation[] antns,
                MediaType mt,
                MultivaluedMap<String, Object> mm,
                OutputStream out) throws IOException, WebApplicationException {
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(t);
    }
}

