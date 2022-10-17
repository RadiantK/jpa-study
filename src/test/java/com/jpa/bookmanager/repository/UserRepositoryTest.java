package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@Slf4j
@SpringBootTest // SpringContext를 로딩해서 Bean을 생성하고 주입
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

//    @BeforeEach
//    void init() {
//        userRepository.save(new User(1, "kang", "kang@fastcampus.com", LocalDateTime.now(),LocalDateTime.now()));
//    }

    @Test
//    @Transactional
    void crud() {
        //이름 역순 정렬
        //List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        //1,3,5번의 정보만 불러오기
        //List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

        //users.forEach(System.out::println);

        //회원저장
//        userRepository.save(new User("newKang", "newKang@fastcampus.com"));
//        User user1 = new User("jack", "jack@fanscampus.com");
//        User user2 = new User("steve", "steve@fanscampus.com");
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);

//        User user = userRepository.findById(1L).orElse(null);
//        log.info("user={}", user);

        //flush
//        userRepository.save(new User("newKang", "newKang@fastcampus.com"));
//        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);

        //count
//        long count = userRepository.count();
//        System.out.println(count);

        //existBYId
//        boolean exists = userRepository.existsById(1L);
//        System.out.println(exists);

        //delete: select 사용 유무 및 iterable 사용 유무
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteById(1L);
//        userRepository.findAll().forEach(System.out::println);
//        userRepository.deleteAllInBatch();

        //paging
//        Page<User> users = userRepository.findAll(PageRequest.of(0, 3));
//
//        System.out.println("page: " + users); //
//        System.out.println("totalElements: " + users.getTotalElements()); // 총 컬럼수
//        System.out.println("totalPages: " + users.getTotalPages()); // 총 페이지 수
//        System.out.println("numberOfElements: " + users.getNumberOfElements());
//        System.out.println("sort: " + users.getSort());
//        System.out.println("size: " + users.getSize());
//        System.out.println();
//
//        // 페이지는 0부터 시작 0 = 1page
//        users.getContent().forEach(System.out::println);

        // queryByExample
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("id")
//                .withIgnorePaths("name") // name컬럼 무시
//                .withMatcher("email", endsWith());
//
//        Example<User> example = Example.of(new User("ka", "kang@fastcampus.com"), matcher);
//        userRepository.findAll(example).forEach(System.out::println);

        //update
        userRepository.save(new User("david", "david@fastcampus.com"));

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("kang-update@fastcampus.com");

        userRepository.save(user);
    }

}