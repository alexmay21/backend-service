package com.todos.backendservice.service;

import com.todos.backendservice.model.entity.ToDoEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * ToDoService
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
public interface ToDoService {
     /**
      * Create a to-do
      */
     ToDoEntity createToDo(ToDoEntity toDoEntity);

     /**
      * Find a to-do by id
      */
     ToDoEntity findToDo(Long id);

     /**
      * Search a to-do using keyword, pageNum, and pageSize
      */
     Page<ToDoEntity> searchToDo(String keyword, int pageNum, int pageSize);

     /**
      * Update a to-do
      */
     ToDoEntity updateToDo(ToDoEntity toDoEntity);

     /**
      * Delete to-dos in batch
      */
     int deleteToDos(List<Long> ids);
}
