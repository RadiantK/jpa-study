package com.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(MyEntityListener.class)
//@EntityListeners(value = {AuditingEntityListener.class})
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    private Long authorId;
    private Long publisherId;

    @OneToOne(mappedBy = "book") // mappedBy 해당테이블에서 연관키를 더이상 가지지 않음
    @ToString.Exclude // 순환 참조 예방
    private BookReviewInfo bookReviewInfo;
}
