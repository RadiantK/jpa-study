package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book1 = new Book();
        book1.setName("Jpa 패키지");
        book1.setAuthor("패스트캠퍼스");

        bookRepository.save(book1);

        log.info("book1={}", bookRepository.findAll());

        Book book2 = bookRepository.findById(6L).orElseThrow(RuntimeException::new);
        book2.setAuthor("작성자");

        bookRepository.save(book2);

        log.info("book2={}", bookRepository.findAll());
    }
}
