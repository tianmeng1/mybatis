package com.tm.mybatis;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tm.mybatis.dao.IPeopleDao;

/**
 * Hello world!
 *
 */
public class App {
    private static ClassPathXmlApplicationContext applicationContext;

    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        
        IPeopleDao peopleDao = applicationContext.getBean(IPeopleDao.class);
        peopleDao.getPeopleByPage();
    }
}
