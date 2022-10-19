package com.jpa.bookmanager.service;

import com.jpa.bookmanager.domain.User;
import com.jpa.bookmanager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class UserService {

    private final EntityManager entityManager;
    private final UserRepository userRepository;

    @Transactional
    public void put() {
        User user = new User();
        user.setName("newUser");
        user.setEmail("newUser@fastcampus.com");

        entityManager.persist(user);
        entityManager.detach(user);

        user.setName("newUserAfterPersist");
        entityManager.merge(user);
        entityManager.flush();
        
        entityManager.clear();
        
//        entityManager.remove(user); // managed(영속) 상태에서 동작

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);
    }
}
