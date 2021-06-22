package com.todos.backendservice.service.impl;

import com.todos.backendservice.dao.ToDoDao;
import com.todos.backendservice.model.entity.ToDoEntity;
import com.todos.backendservice.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Implementation of ToDoService
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    private ToDoDao toDoDao;

    @Override
    public ToDoEntity createToDo(ToDoEntity toDoEntity) {
        return toDoDao.save(toDoEntity);
    }

    @Override
    public ToDoEntity findToDo(Long id) {
        return toDoDao.find(id);
    }

    @Override
    public Page<ToDoEntity> searchToDo(String keyword, int pageNum, int pageSize) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize < 1) {
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

        if (null == keyword) {
            return toDoDao.findAll(pageable);
        }

        Specification<ToDoEntity> specification = new Specification<ToDoEntity>() {
            @Override
            public Predicate toPredicate(Root<ToDoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("name").as(String.class)), "%" + keyword.toLowerCase() + "%");
            }
        };
        return toDoDao.findAll(specification, pageable);
    }

    @Override
    public ToDoEntity updateToDo(ToDoEntity toDoEntity) {
        return toDoDao.save(toDoEntity);
    }

    @Override
    @Transactional
    public int deleteToDos(List<Long> idList) {
        return toDoDao.batchDeleteToDos(idList);
    }
}
