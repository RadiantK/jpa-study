package com.jpa.bookmanager.service;

import com.jpa.bookmanager.domain.Book;
import com.jpa.bookmanager.repository.AuthorRepository;
import com.jpa.bookmanager.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void transactionTest() {

//        bookService.putBookAndAuthor();

        Assertions.assertThatThrownBy(() -> bookService.putBookAndAuthor())
                .isInstanceOf(RuntimeException.class);

        log.info("books={}", bookRepository.findAll());
        log.info("authors={}", authorRepository.findAll());
    }

    @Test
    void isolationTest() {
        Book book = new Book();
        book.setName("JPA 강의");

        bookRepository.save(book);

        bookService.get(1L);

        log.info(">>>{}", bookRepository.findAll());
    }

    @Test
    void converterErrorTest() {
        bookService.getAll();

        bookRepository.findAll().forEach(b -> log.info("log books={}", b));
    }
}