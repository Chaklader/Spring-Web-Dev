package com.baeldung.web.controller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.model.Book;
import com.baeldung.model.Cart;
import com.baeldung.persistence.BookRepository;
import com.baeldung.web.error.Checks;
import com.baeldung.web.resource.BookResource;
import com.baeldung.web.resource.CartResource;
import com.baeldung.web.resource.NewBookResource;


@RestController
@RequestMapping(value = "/cart")
public class CartController implements InitializingBean {

    private Cart cart;

    @Autowired
    private BookRepository bookRepo;

    // read

    @RequestMapping(method = RequestMethod.GET)
    public CartResource seeYourCart() {
        return toResource();
    }

    // write

    @RequestMapping(method = RequestMethod.POST)
    public CartResource addBookToCart(@RequestBody final BookResource book) {
        final String isbn = book.getBook().getIsbn();
        final Book bookToAdd = Checks.checkEntityExists(bookRepo.findByIsbn(book.getBook().getIsbn()), "No Book found for isbn: " + isbn);

        this.cart.add(bookToAdd);
        return toResource();
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public CartResource addNewBookToCart(@RequestBody final NewBookResource book) {
        final String isbn = book.getBook().getIsbn();
        final Book bookToAdd = Checks.checkEntityExists(bookRepo.findByIsbn(book.getBook().getIsbn()), "No Book found for isbn: " + isbn);

        this.cart.add(bookToAdd);
        return toResource();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public CartResource buy(@RequestBody final CartResource theCart) {
        this.cart.setPurchased(theCart.isPurchased());

        return toResource();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public CartResource clearYourCart() {
        this.cart.getBooks().clear();
        this.cart.setPurchased(false);

        return toResource();
    }

    //

    private CartResource toResource() {
        return new CartResource(this.cart.getBooks(), this.cart.isPurchased());
    }

    @Override
    public void afterPropertiesSet() {
        this.cart = new Cart();
    }

}
