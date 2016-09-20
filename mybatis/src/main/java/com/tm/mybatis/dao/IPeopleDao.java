package com.tm.mybatis.dao;

import java.util.List;

import com.tm.mybatis.entity.People;

public interface IPeopleDao {
    public List<People> getPeopleByPage();
}
