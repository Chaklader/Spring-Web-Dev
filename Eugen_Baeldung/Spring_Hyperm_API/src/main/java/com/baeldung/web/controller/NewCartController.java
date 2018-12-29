package com.baeldung.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.model.Book;
import com.baeldung.persistence.BookRepository;
import com.baeldung.web.error.Checks;
import com.baeldung.web.resource.BookResource;
import com.baeldung.web.resource.CartResource;
import com.baeldung.web.resource.NewCartResource;

import jersey.repackaged.com.google.common.collect.Lists;

@RestController
@RequestMapping(value = "/new/cart")
public class NewCartController {

    private List<Book> books;
    private boolean cartPurchased;

    @Autowired
    private BookRepository bookRepo;

    // read

    @RequestMapping(method = RequestMethod.GET)
    public NewCartResource seeYourCart() {
        return new NewCartResource(initializeBooksInCart(), bookLinks(books), cartPurchased);
    }

    // write

    @RequestMapping(method = RequestMethod.POST)
    public NewCartResource addBookToCart(@RequestBody final BookResource book) {
        final String isbn = book.getBook().getIsbn();
        final Book bookToAdd = Checks.checkEntityExists(bookRepo.findByIsbn(book.getBook().getIsbn()), "No Book found for isbn: " + isbn);

        initializeBooksInCart().add(bookToAdd);

        return new NewCartResource(books, cartPurchased);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public NewCartResource buy(@RequestBody final CartResource theCart) {
        NewCartResource cart = new NewCartResource(initializeBooksInCart(), cartPurchased);

        if (theCart.isPurchased()) {
            cartPurchased = true;
            cart.setPurchased(cartPurchased);
        }

        cart.add(new Link("http://localhost:8081/api/receipt/1").withRel("receipt"));
        return cart;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void clearYourCart() {
        initializeBooksInCart().clear();
        this.cartPurchased = false;
    }

    //

    List<Book> initializeBooksInCart() {
        if (books == null) {
            this.books = Lists.newArrayList();
        }

        return this.books;
    }

    List<Link> bookLinks(final List<Book> theBooks) {
        return theBooks.stream().map(this::getLink).collect(Collectors.toList());
    }

    Link getLink(final Book book) {
        return linkTo(BookController.class).slash(book.getIsbn()).withSelfRel();
    }

}
