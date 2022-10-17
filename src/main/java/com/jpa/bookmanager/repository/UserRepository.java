package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name); // 이름으로 레코드를 하나 얻어옴

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String emaill);

    User findUserByEmail(String email);

    User findSomethingByEmail(String email);

    User findFirst1ByName(String name); //List<User> findFirst1ByName(String name);

    User findTop1ByName(String name); //List<User> findTop1ByName(String name);

    User findByEmailAndName(String email, String name);

    List<User> findByEmailOrName(String email, String name);

    List<User> findByCreatedAtAfter(LocalDateTime localDateTime); // 특정날짜보다 큰 날짜
    List<User> findByCreatedAtBefore(LocalDateTime localDateTime); // 특정날짜보다 작은 날짜

    List<User> findByIdAfter(Long id); // 특정 아이디보다 큰 값

    List<User> findByCreatedAtGreaterThan(LocalDateTime localDateTime);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime localDateTime);

    List<User> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);

    List<User> findByIdBetween(Long id1, Long id2);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<User> findByIdIsNotNull();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String name);

    List<User> findByNameEndingWith(String name);

    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);

    List<User> findByNameIs(String name); // is: 코드 가독성 용도

    // paging and sorting
    List<User> findTop1ByNameOrderByIdDesc(String name);

    List<User> findTopByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);

}
