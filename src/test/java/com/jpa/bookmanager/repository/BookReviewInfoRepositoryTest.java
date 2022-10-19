package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Book;
import com.jpa.bookmanager.domain.BookReviewInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    @Transactional
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(createBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);

        log.info("bookReviewInfo={}", bookReviewInfoRepository.findAll());
    }

/*
    @Test
    void crudTest2() {
        createBookReviewInfo();

        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new).getBook();

        log.info("Book result={}", result);

        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();
        log.info("BookReviewInfo result2={}", result2);
    }
*/

    private Book createBook() {
        Book book = new Book();
        book.setName("Jpa 패키지");
//        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        Book saveBook = bookRepository.save(book);
        log.info("book={}", saveBook);

        return saveBook;
    }

    private void createBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(createBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewInfoRepository.save(bookReviewInfo);
        log.info("bookReviewInfoRepository findAll={}", bookReviewInfoRepository.findAll());
    }
}