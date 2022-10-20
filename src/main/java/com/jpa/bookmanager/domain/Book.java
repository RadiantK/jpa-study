package com.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "deleted = false")
//@EntityListeners(MyEntityListener.class)
//@EntityListeners(value = {AuditingEntityListener.class})
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    @OneToOne(mappedBy = "book") // mappedBy 해당테이블에서 연관키를 더이상 가지지 않음
    @ToString.Exclude // 순환 참조 예방
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name = "book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @ToString.Exclude
    private Publisher publisher;

//    @ManyToMany
    @OneToMany
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();

    private boolean deleted;

    public void addBookAndAuthors(BookAndAuthor ...bookAndAuthors) {
        Collections.addAll(this.bookAndAuthors, bookAndAuthors);
    }

}
