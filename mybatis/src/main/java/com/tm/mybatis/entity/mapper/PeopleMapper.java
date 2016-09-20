package com.tm.mybatis.entity.mapper;

import java.util.List;

import com.tm.mybatis.entity.People;

public interface PeopleMapper {
    // 方法名要与mapper配置文件中一致
    public List<People> getPeople();
}
