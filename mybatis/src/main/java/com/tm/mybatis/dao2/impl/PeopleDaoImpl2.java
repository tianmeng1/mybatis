package com.tm.mybatis.dao2.impl;

import java.util.List;

import com.tm.mybatis.dao2.IPeopleDao2;
import com.tm.mybatis.dao2.base.MybatisBaseDao;
import com.tm.mybatis.entity.People;
import com.tm.mybatis.entity.mapper.PeopleMapper;

public class PeopleDaoImpl2 extends MybatisBaseDao<PeopleMapper> implements IPeopleDao2{

    @Override
    public List<People> getPeopleByPage() {
        List<People> list = mapper.getPeople();
        return list;
    }
}
