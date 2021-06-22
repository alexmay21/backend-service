package com.todos.backendservice.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

/**
 * ToDoEntity
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
@Data
public class ToDoEntity extends BaseEntity {
    @Column(name="name",length=128)
    private String name;

    @Column(name="completed")
    protected boolean completed;
}
