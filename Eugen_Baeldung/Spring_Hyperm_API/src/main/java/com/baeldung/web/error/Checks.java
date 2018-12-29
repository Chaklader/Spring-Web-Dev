package com.baeldung.web.error;

import javax.persistence.EntityNotFoundException;

public final class Checks {

    private Checks() {
        super();
    }

    //

    public static final <T> T checkEntityExists(T entity, final String message) {
        if (entity == null) {
            throw new EntityNotFoundException(message);
        }
        return entity;
    }

}
