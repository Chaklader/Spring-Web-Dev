package com.baeldung.web.resource;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;
import static org.springframework.hateoas.mvc.BasicLinkBuilder.linkToCurrentMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import com.baeldung.model.Book;
import com.baeldung.web.controller.CartController;

public class CartResource extends ResourceSupport {

    private List<Book> books;

    private boolean purchased;

    public CartResource() {
        super();
    }

    public CartResource(final List<Book> books, final boolean purchased) {
        super();

        this.books = books;
        this.purchased = purchased;

        this.add(linkTo(methodOn(CartController.class).seeYourCart()).withSelfRel());
        if (!purchased && !this.books.isEmpty()) {
            Link clearLink = null;
            try {
                clearLink = linkTo(CartController.class, CartController.class.getMethod("clearYourCart")).withRel("clear");
            } catch (NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
            this.add(clearLink);
        }
        if (purchased) {
            this.add(linkToCurrentMapping().slash("/receipt").slash(randomAlphanumeric(6)).withRel("receipt"));
        }
    }

    //

    public void setBooks(final List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

}
