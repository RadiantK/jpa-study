package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Book;
import com.jpa.bookmanager.domain.Publisher;
import com.jpa.bookmanager.domain.Review;
import com.jpa.bookmanager.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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

    @Test
    void bookCascadeTest() {
        Book book = new Book();
        book.setName("JPA 패키지");

//        bookRepository.save(book);

        Publisher publisher = new Publisher();
        publisher.setName("패스트 캠퍼스");

//        publisherRepository.save(publisher);

        book.setPublisher(publisher);
        bookRepository.save(book);

//        publisher.getBooks().add(book);
//        publisher.addBook(book);
//        publisherRepository.save(publisher);

        System.out.println("books: " + bookRepository.findAll());
        System.out.println("publisher: " + publisherRepository.findAll());

        Book book1 = bookRepository.findById(1L).orElse(null);
        book1.getPublisher().setName("슬로우");

        bookRepository.save(book1);

        System.out.println("publishers = " + publisherRepository.findAll());

        Book book2 = bookRepository.findById(1L).orElse(null);
//        bookRepository.delete(book2);

        Book book3 = bookRepository.findById(1L).orElse(null);
        book3.setPublisher(null);

        bookRepository.save(book3);

        System.out.println("books = " + bookRepository.findAll());
        System.out.println("publishers = " + publisherRepository.findAll());
        System.out.println("book3-publisher = " + bookRepository.findById(1L).get().getPublisher());
    }

    @Test
    void bookRemoveCascadeTest() {
        bookRepository.deleteById(1L);

        System.out.println("books: " + bookRepository.findAll());
        System.out.println("publisher: " + publisherRepository.findAll());

        bookRepository.findAll().forEach(book -> System.out.println(book.getPublisher()));
    }

    @Test
    void softDelete() {
        bookRepository.findAll().forEach(System.out::println);
        System.out.println(bookRepository.findById(3L));

//        bookRepository.findByCategoryIsNull().forEach(System.out::println);
//        bookRepository.findAllByDeletedFalse().forEach(System.out::println);
//        bookRepository.findByCategoryIsNullAndDeletedFalse().forEach(System.out::println);
    }

    @Test
    void queryTest() {
        bookRepository.findAll().forEach(System.out::println);

        System.out.println(
                "bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual() = " + bookRepository.findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(
                        "JPA 패키지", LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusDays(1L)));

        System.out.println("findByNameRecently: " + bookRepository.findByNameRecently("JPA 패키지", LocalDateTime.now().minusDays(1L), LocalDateTime.now().minusDays(1L)));

        System.out.println("bookNameAndCategory: " + bookRepository.findBookNameAndCategory());
        bookRepository.findBookNameAndCategory().forEach(b -> {
            System.out.println(b.getName() + ", " + b.getCategory());
        });
    }

    @Test
    void pageableTest() {
        bookRepository.findBookNameAndCategory("%" + "Spring" + "%" , PageRequest.of(0, 1))
                .forEach(b -> {
                    System.out.println(b.getName() + ", " + b.getCategory());
                });
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
