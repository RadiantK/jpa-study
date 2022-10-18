package com.jpa.bookmanager.domain;

import com.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(value = {UserEntityListener.class})
@ToString(callSuper = true) // 상속받는 클래스의 값을 포함
@EqualsAndHashCode(callSuper = true)
//@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    @NonNull
//    @Column(unique = true)
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false) // entity가 어떤 컬럼으로 조인하게될 것인지 지정
    private List<UserHistory> userHistories = new ArrayList<>();
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
