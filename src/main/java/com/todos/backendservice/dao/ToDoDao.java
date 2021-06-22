package com.todos.backendservice.dao;

import com.todos.backendservice.model.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ToDoDao
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@Repository
public interface ToDoDao extends JpaRepository<ToDoEntity, Long>, JpaSpecificationExecutor<ToDoEntity> {
    @Query("select t from ToDoEntity t where t.id = :id")
    ToDoEntity find(@Param("id") Long id);

    @Query("delete from ToDoEntity t where t.id in :idList")
    @Modifying
    int batchDeleteToDos(@Param("idList") List<Long> idList);
}
