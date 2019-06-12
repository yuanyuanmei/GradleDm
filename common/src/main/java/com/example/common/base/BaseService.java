package com.example.common.base;

import com.example.common.dto.PageDto;
import com.github.pagehelper.PageInfo;

public interface BaseService<T> {

    PageInfo<T> pageList(PageDto pageDto);

    T selectByPrimaryKey(Long id);

    int delete(Integer id);

    int insert(T t);

    int update(T t);
}
