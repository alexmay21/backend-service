package com.todos.backendservice.controller;

import com.todos.backendservice.model.dto.CommonPage;
import com.todos.backendservice.model.dto.CommonResult;
import com.todos.backendservice.model.dto.ToDoDTO;
import com.todos.backendservice.model.entity.ToDoEntity;
import com.todos.backendservice.service.ToDoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * ToDoController
 *
 * @author Lei Mei
 * @date 2021/06/22
 */
@RestController
@RequestMapping("/to-dos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @ApiOperation(value = "Create a to-do")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<ToDoEntity> createToDo(@Validated @RequestBody ToDoDTO toDoDTO) {
        ToDoEntity toDoEntity = toDoDTO.toEntity();
        toDoEntity = toDoService.createToDo(toDoEntity);
        if (null == toDoEntity) {
            return CommonResult.failed("Failed to create the to-do.");
        }
        return CommonResult.success(toDoEntity);
    }

    @ApiOperation(value = "Search a to-do")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<ToDoEntity>> searchToDo(@RequestParam(value = "keyword", required = false) String keyword,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        keyword = StringUtils.stripToNull(keyword);
        Page<ToDoEntity> page = toDoService.searchToDo(keyword, pageNum, pageSize);

        return CommonResult.success(CommonPage.convert(page));
    }

    @ApiOperation(value = "Update a to-do")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<ToDoEntity> updateToDo(@PathVariable Long id, @Validated @RequestBody ToDoDTO toDoDTO) {
        ToDoEntity toDoEntity = toDoService.findToDo(id);
        if (null == toDoEntity) {
            return CommonResult.failed("The to-do with id " + id + " does not exist.");
        }
        BeanUtils.copyProperties(toDoDTO, toDoEntity);

        toDoEntity = toDoService.updateToDo(toDoEntity);
        if (null == toDoEntity) {
            return CommonResult.failed("Failed to update the to-do.");
        }
        return CommonResult.success(toDoEntity);
    }

    @ApiOperation(value = "Delete to-dos in batch")
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<String> deleteToDo(@ApiParam(value = "The ids of to-dos (connect using comma. Example: 2,3,4)") @RequestParam(value = "ids") String ids) {
        List<Long> idList = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());
        if (idList.size() < 1) {
            return CommonResult.failed("The size of id list cannot be less than 1.");
        }

        int count = toDoService.deleteToDos(idList);
        if (count >= 1) {
            return CommonResult.success("Succeed in deleting to-dos in batch.");
        } else {
            return CommonResult.failed("Failed to delete to-dos in batch.");
        }
    }
}
