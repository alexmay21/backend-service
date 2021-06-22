package com.todos.backendservice.model.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Common used class for pagination
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@Data
public class CommonPage<T> {
    /**
     * Current page number
     */
    private Integer pageNum;

    /**
     * Size per page
     */
    private Integer pageSize;

    /**
     * Total page count
     */
    private Integer totalPage;

    /**
     * Total number
     */
    private Long total;

    /**
     * Content
     */
    private List<T> list;

    /**
     * Convert page info
     */
    public static <T> CommonPage<T> convert(Page<T> page) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage(page.getTotalPages());
        result.setPageNum(page.getNumber() + 1);
        result.setPageSize(page.getSize());
        result.setTotal(page.getTotalElements());
        result.setList(page.getContent());
        return result;
    }
}
