package com.baeldung.web.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.model.Book;
import com.baeldung.model.BookView;
import com.baeldung.persistence.BookRepository;
import com.baeldung.web.error.Checks;
import com.baeldung.web.resource.BookResource;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookRepository repo;

    // read

    @RequestMapping("/{isbn}")
    public BookResource findByIsbn(@PathVariable final String isbn) {
        final Book book = Checks.checkEntityExists(repo.findByIsbn(isbn), "No book found for isbn = " + isbn);

        final BookResource bookResource = new BookResource(book);
        bookResource.add(linkTo(methodOn(CartController.class).addBookToCart(bookResource)).withRel("add-to-cart"));

        return bookResource;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookResource> findAll() {
        final List<Book> books = (List<Book>) repo.findAll();
        final List<BookResource> bookResources = books.stream().map(BookResource::new).collect(Collectors.toList());
        return bookResources;
    }

    @JsonView(BookView.Summary.class)
    @RequestMapping(method = RequestMethod.GET, params="summary")
    public List<BookResource> findAllSummary() {
        final List<Book> books = (List<Book>) repo.findAll();
        final List<BookResource> bookResources = books.stream().map(BookResource::new).collect(Collectors.toList());
        return bookResources;
    }

    // write

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody BookResource newBook) {
        repo.save(newBook.getBook());
    }

}
