package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Book;
import com.jpa.bookmanager.domain.Publisher;
import com.jpa.bookmanager.domain.Review;
import com.jpa.bookmanager.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book1 = new Book();
        book1.setName("Jpa 패키지");
//        book1.setAuthorId(1L);
//        book1.setPublisherId(1L);

        bookRepository.save(book1);

        log.info("book1={}", bookRepository.findAll());

//        Book book2 = bookRepository.findById(1L).orElseThrow(RuntimeException::new);
////        book2.setAuthorId(2L);
//
//        bookRepository.save(book2);
//
//        log.info("book2={}", bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("kang@fastcampus.com");

        System.out.println("Review: " + user.getReviews());
        System.out.println("Book: " + user.getReviews().get(0).getBook());
        System.out.println("Publisher: " + user.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private User givenUser() {
        return userRepository.findByEmail("kang@fastcampus.com");
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 패키지");
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("패스트캠퍼스");

        return publisherRepository.save(publisher);
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("JPA학습책");
        review.setContent("공부하고있습니다.");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
}
