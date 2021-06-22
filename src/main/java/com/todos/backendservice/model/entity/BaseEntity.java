package com.todos.backendservice.model.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Base entity
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "id", nullable = false, length = 11)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "create_time", nullable = false)
    @CreatedDate
    private Date createdTime;

    @Column(name = "update_time", nullable = false)
    @LastModifiedDate
    private Date updateTime;
}
