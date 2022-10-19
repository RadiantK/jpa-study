package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Gender;
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
    @Autowired
    private UserHistoryRepository userHistoryRepository;

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

    @Test
    void select() {
//        log.info("findByName={}", userRepository.findByName("mark"));
//
//        System.out.println("findByEmail: " + userRepository.findByEmail("kang@fastcampus.com"));
//        System.out.println("getByEmail: " + userRepository.getByEmail("kang@fastcampus.com"));
//        System.out.println("readByEmail: " + userRepository.readByEmail("kang@fastcampus.com"));
//        System.out.println("queryByEmail: " + userRepository.queryByEmail("kang@fastcampus.com"));
//        System.out.println("searchByEmail: " + userRepository.searchByEmail("kang@fastcampus.com"));
//        System.out.println("streamByEmail: " + userRepository.streamByEmail("kang@fastcampus.com"));
//        System.out.println("findUserByEmail: " + userRepository.findUserByEmail("kang@fastcampus.com"));
//        System.out.println("findSomethingUserByEmail: " + userRepository.findSomethingByEmail("kang@fastcampus.com"));
//
//        System.out.println("findFirst1ByName: " + userRepository.findFirst1ByName("kang"));
//        System.out.println("findTop1ByName: " + userRepository.findTop1ByName("kang"));

//        System.out.println("findByEmailAndName: " + userRepository.findByEmailAndName("kang@fastcampus.com", "kang"));
//        System.out.println("findByEmailOrName: " + userRepository.findByEmailOrName("kang@fastcampus.com", "mark"));
//        System.out.println("findByCreatedAtAfter: " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByIdAfter: " + userRepository.findByIdAfter(3L));
//        System.out.println("findByCreatedAtGreaterThan: " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println("findByCreatedAtGreaterThanEqual: " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
//
//        System.out.println("findByCreatedAtBetween: " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println("findByIdBetween: " + userRepository.findByIdBetween(1L, 3L));
//        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual: " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

//        System.out.println("findByIdIsNotNull: " + userRepository.findByIdIsNotNull());
//        System.out.println("findByNameIn: " + userRepository.findByNameIn(List.of("kang", "mark")));

//        System.out.println("findByNameStartingWith: " + userRepository.findByNameStartingWith("kan"));
//        System.out.println("findByNameEndingWith: " + userRepository.findByNameEndingWith("ang"));
//        System.out.println("findByNameContains: " + userRepository.findByNameContains("an"));
//        System.out.println("findByNameLike: " + userRepository.findByNameLike("%"+"an"+"%"));
//        System.out.println("findByNameIs: " + userRepository.findByNameIs("kang"));
    }

    @Test
    void pagingAndSortingTest() {

        //sorting
//        System.out.println("findTop1ByName: " + userRepository.findTop1ByName("kang"));
//        System.out.println("findTop1ByNameOrderByIdDesc: " + userRepository.findTop1ByNameOrderByIdDesc("kang"));
//        System.out.println("findTopByNameOrderByIdDesc: " + userRepository.findTopByNameOrderByIdDesc("kang"));
//        System.out.println("findFirstByNameOrderByIdDescEmailAsc: " + userRepository.findFirstByNameOrderByIdDescEmailAsc("kang"));
//        System.out.println("findFirstByNameWithSortParams: " + userRepository.findFirstByName("kang", Sort.by(Sort.Order.desc("id"), Sort.Order.desc("email"))));

        // paging
        System.out.println("findByNameWithPaging: " + userRepository.findByName("kang", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
    }

    @Test
    void insertAndUpdateTest() {
        User user = new User();
        user.setName("radiant");
        user.setEmail("radiant@naver.com");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("rrrrrradiant");

        userRepository.save(user2);
    }

    @Test
    void enumTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));
    }

    @Test
    void prePersistTest() {
        User user = new User();
        user.setName("radi");
        user.setEmail("radi@naver.com");

        userRepository.save(user);

        System.out.println(userRepository.findByEmail("radi@naver.com"));
    }

    @Test
    void preUpdateTest() {
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is: " + user);

        user.setName("kang-22");
        userRepository.save(user);

        System.out.println("to-be: " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest() {
        User user = new User();
        user.setEmail("kang-new@fastcampus.com");
        user.setName("kang-new");

        userRepository.save(user);

        user.setName("kang-new-new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest() {
        User user = new User();
        user.setName("radi");
        user.setEmail("radi@naver.com");
        user.setGender(Gender.MALE);
        userRepository.save(user);

//        userHistoryRepository.findAll().forEach(System.out::println);

        user.setName("daniel");
        userRepository.save(user);

        user.setEmail("daniel@naver.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

//        userHistoryRepository.findByUserId(
//                userRepository.findByEmail("daniel@naver.com").getId())
//                .forEach(System.out::println);

        userRepository.findByEmail("daniel@naver.com").getUserHistories().forEach(System.out::println);

        System.out.println("UserHistory.getUser(): " + userHistoryRepository.findAll().get(0).getUser());
    }
}