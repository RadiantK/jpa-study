package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Review;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@SpringBootTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    void reviewTest() {
        List<Review> reviews = reviewRepository.findAll();
//        List<Review> reviews = reviewRepository.findAllByFetchJoin();
//        List<Review> reviews = reviewRepository.findAllByEntityGraph();

        System.out.println(reviews.get(0).getComments());
//        reviews.forEach(review -> log.info("review={}", review));
//        System.out.println("전체 가져오기");
//        System.out.println(reviews.get(0).getComments());
//        System.out.println("첫 번째 리뷰의 코멘트를 가져옴");
//
//        System.out.println(reviews.get(1).getComments());
//        System.out.println("두 번째 리뷰의 코멘트를 가져옴");

//        reviews.forEach(System.out::println);
    }
}
