package com.todos.backendservice.model.dto;

import com.todos.backendservice.model.entity.ToDoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;

/**
 * ToDoDTO
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@Data
public class ToDoDTO {
    @ApiModelProperty(value = "Name of the to-do", dataType = "String", required = true)
    @NotBlank(message = "Name cannot be blank.")
    private String name;

    @ApiModelProperty(value = "Status of the to-do", dataType = "Boolean", required = true)
    private boolean completed = false;

    public ToDoEntity toEntity() {
        ToDoEntity toDoEntity = new ToDoEntity();
        BeanUtils.copyProperties(this, toDoEntity);
        return toDoEntity;
    }
}
