package com.example.common.base;

import com.alibaba.fastjson.JSONObject;
import com.example.common.dto.PageDto;
import com.github.pagehelper.PageInfo;

public interface BaseService<T> {

    JSONObject pageList(PageDto pageDto);

    JSONObject selectByPrimaryKey(Long id);

    JSONObject delete(Long id);

    JSONObject insert(T t);

    JSONObject update(T t);
}
