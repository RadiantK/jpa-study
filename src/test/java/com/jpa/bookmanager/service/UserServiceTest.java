package com.jpa.bookmanager.service;

import com.jpa.bookmanager.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        userService.put();

        log.info("user={}", userRepository.findByEmail("newUser@fastcampus.com"));

        userRepository.findAll().forEach(u -> log.info("removeUser={}", u));
    }
}