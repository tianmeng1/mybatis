package com.tm.mybatis.dao2.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.PostConstruct;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class MybatisBaseDao<T> extends SqlSessionDaoSupport {
    protected T mapper = null;

    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    /**
     * 
     * @描述：dao层获取mapper
     * @return void
     * @exception
     * @createTime：2016年6月16日
     * @author: 
     */
    @PostConstruct
    public void initMapper() {
        // Dao的直接超类：BaseDao<T>， 是一个参数化类型
        ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] typeArr = parameterizedType.getActualTypeArguments();
        Type type = null;
        if (typeArr == null || typeArr.length != 1) {
            logger.error(getClass().getName() + " init failed,connot find generic paradigm T.");
        } else {
            type = typeArr[0];
        }

        @SuppressWarnings("unchecked")
        T mapper = getSqlSession().getMapper((Class<T>) type);
        if (mapper == null) {
            logger.error(getClass().getName() + " init failed,connot find matched mapper.");
        }
        this.mapper = mapper;
    }
}
