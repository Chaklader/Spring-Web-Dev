package com.baeldung.persistence;

import org.springframework.data.repository.CrudRepository;

import com.baeldung.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(final String isbn);

}
