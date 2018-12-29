package com.halyph.rest.provider;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    /**
     * Map an exception to a {@link javax.ws.rs.core.Response}.
     *
     * @param exception the exception to map to a response.
     * @return a response mapped from the supplied exception.
     */
    @Override
    public Response toResponse(final NotFoundException exception) {
        Map<String, Object> info = new HashMap<>();
        info.put("msg", exception.getMessage());
        info.put("date", new Date());
        info.put("details", "The requested resource hasn't been found");

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(info)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}

