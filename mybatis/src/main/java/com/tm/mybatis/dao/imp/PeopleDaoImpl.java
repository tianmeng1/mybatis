package com.tm.mybatis.dao.imp;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tm.mybatis.dao.IPeopleDao;
import com.tm.mybatis.entity.People;
import com.tm.mybatis.entity.mapper.PeopleMapper;

/**
 * 每个dao都需要继承sqlSessionDaoSupport，并且需要注入sqlSessionTempate。可以将该代码提取出来，见dao2包
 * @author 
 *
 */
@Service
public class PeopleDaoImpl extends SqlSessionDaoSupport implements IPeopleDao {
    
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
    
    @Override
    public List<People> getPeopleByPage() {
        PeopleMapper mapper = getSqlSession().getMapper(PeopleMapper.class);
        List<People> list = mapper.getPeople();
        System.out.println(list.size());
        return null;
    }

}
