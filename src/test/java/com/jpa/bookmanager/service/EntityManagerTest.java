package com.jpa.bookmanager.service;

import com.jpa.bookmanager.domain.User;
import com.jpa.bookmanager.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@SpringBootTest
public class EntityManagerTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;

    @Test
    void EntityManagerTest() {
        List result = em.createQuery("select u from User u").getResultList();
        log.info("result={}", result);
    }

    @Test
    @Transactional
    void cacheFindTest() {
//        log.info("user1={}", userRepository.findByEmail("kang@fastcampus.com"));
//        log.info("user2={}", userRepository.findByEmail("kang@fastcampus.com"));
//        log.info("user3={}", userRepository.findByEmail("kang@fastcampus.com"));

        log.info("user={}", userRepository.findById(1L).orElse(null));
        log.info("user={}", userRepository.findById(1L).orElse(null));
        log.info("user={}", userRepository.findById(1L).orElse(null));
    }

    @Test
    @Transactional
    void cacheFindTest2() {
        User user = userRepository.findById(1L).get();
        user.setName("kaaaaaaaaaaaang");
//        userRepository.flush();
//        userRepository.save(user);

        user.setEmail("kaaaaaaaaaaang@fastcampus.com");
//        userRepository.flush();
//        userRepository.save(user);
    }
}
