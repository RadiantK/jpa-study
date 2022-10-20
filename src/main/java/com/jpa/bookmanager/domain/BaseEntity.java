package com.jpa.bookmanager.domain;

import com.jpa.bookmanager.domain.listener.Auditable;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass // 해당 클래스의 필드를 상속받는 엔티티의 컬럼으로 포함시키는 컬럼
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseEntity implements Auditable {

    @CreatedDate
    @Column(columnDefinition = "datetime default now()", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(columnDefinition = "datetime default now()", nullable = false)
    private LocalDateTime updatedAt;
}
