package com.jpa.bookmanager.domain;

import com.jpa.bookmanager.domain.listener.Auditable;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class UserHistory extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    private String name;
    private String email;

}
