package com.jpa.bookmanager.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

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

    @Column(name = "created_at", updatable = false) // 업데이트시 컬럼이 업데이트 되지 않음
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
