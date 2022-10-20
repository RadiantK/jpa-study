package com.jpa.bookmanager.repository;

import com.jpa.bookmanager.domain.Book;
import com.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import java.time.LocalDateTime;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Modifying
    @Query(value = "update book set category='none'", nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();

    List<Book> findAllByDeletedFalse();

    List<Book> findByCategoryIsNullAndDeletedFalse();

    List<Book> findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createdAt, LocalDateTime updatedAt);

//    @Query(value = "select b from Book b " +
//            "where b.name = ?1 and b.createdAt >= ?2 and b.updatedAt = ?3 and b.category is null")
//    List<Book> findByNameRecently( String name, LocalDateTime createdAt, LocalDateTime updatedAt);

    @Query(value = "select b from Book b " +
            "where b.name = :name and b.createdAt >= :createdAt and b.updatedAt >= :updatedAt and b.category is null")
    List<Book> findByNameRecently(@Param("name") String name,
                                  @Param("createdAt") LocalDateTime createdAt,
                                  @Param("updatedAt") LocalDateTime updatedAt);

    @Query(value = "select new com.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b")
    List<BookNameAndCategory> findBookNameAndCategory();

    @Query(value = "select new com.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name, b.category) from Book b where b.name like :name")
    List<BookNameAndCategory> findBookNameAndCategory(@Param("name") String name, Pageable pageable);

}
