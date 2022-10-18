package com.jpa.bookmanager.domain;

import com.jpa.bookmanager.domain.listener.Auditable;
import com.jpa.bookmanager.domain.listener.MyEntityListener;
import com.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@EntityListeners(value = {MyEntityListener.class})
@EntityListeners(value = {UserEntityListener.class})
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
//@EntityListeners(value = {MyEntityListener.class, AuditingEntityListener.class})
//@Table(name = "user")
//public class User implements Auditable {
public class User extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    @NonNull
//    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

/*
    @CreatedDate
    @Column(name = "created_at", updatable = false) // 업데이트시 컬럼이 업데이트 되지 않음
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
*/

/*
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
*/
}
