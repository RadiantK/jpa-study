package com.jpa.bookmanager.service;

import com.jpa.bookmanager.domain.Author;
import com.jpa.bookmanager.domain.Book;
import com.jpa.bookmanager.repository.AuthorRepository;
import com.jpa.bookmanager.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Transactional
    public void putBookAndAuthor() {
        Book book = new Book();
        book.setName("JPA 시작하기");

        bookRepository.save(book);

        Author author = new Author();
        author.setName("radiant");

        authorRepository.save(author);

        throw new RuntimeException("오류로 인한 coomit이 실패");
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void get(Long id) {
        log.info(">>> {}", bookRepository.findById(id));
        log.info(">>> {}", bookRepository.findAll());

        log.info(">>> {}", bookRepository.findById(id));
        log.info(">>> {}", bookRepository.findAll());

        Book book = bookRepository.findById(id).get();
        book.setName("바뀌는가?");
        bookRepository.save(book);
    }

    @Transactional
    public List<Book> getAll() {
        List<Book> books = bookRepository.findAll();

        books.forEach(b -> log.info("log books={}", b));

        return books;
    }
}
