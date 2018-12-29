package com.baeldung.web.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;

import com.baeldung.model.Book;
import com.baeldung.web.controller.NewCartController;

import jersey.repackaged.com.google.common.collect.Lists;

public class NewCartResource extends ResourceSupport {

    private final Resources<Book> books;

    private boolean purchased;

    public NewCartResource(final Iterable<Book> books, final boolean purchased) {
        super();

        this.books = new Resources<Book>(books, Lists.newArrayList());
        this.purchased = purchased;
        this.add(linkTo(methodOn(NewCartController.class).seeYourCart()).withSelfRel());
    }

    public NewCartResource(final Iterable<Book> books, final List<Link> links, final boolean purchased) {
        super();

        this.books = new Resources<Book>(books, links);
        this.purchased = purchased;
        this.add(linkTo(methodOn(NewCartController.class).seeYourCart()).withSelfRel());
    }

    //

    public Resources<Book> getBooks() {
        return books;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

}
