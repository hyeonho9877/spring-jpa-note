package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SpringBootTest
public class NativeQueriesTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void native_queries_basic() {
        Query query = em.createNativeQuery("select * from course;", Course.class);
        List resultList = query.getResultList();
        logger.info("select all result -> {}", resultList);
    }

    @Test
    void native_queries_position_parameter() {
        Query query = em.createNativeQuery("select * from course where id = ?;", Course.class);
        query.setParameter(1, 10001L);
        List resultList = query.getResultList();
        logger.info("select where id is 10001 result -> {}", resultList);
    }

    @Test
    void native_queries_named_parameter() {
        Query query = em.createNativeQuery("select * from course where id = :id", Course.class);
        query.setParameter("id", 10001L);
        List resultList = query.getResultList();
        logger.info("select where id is 10001 result -> {}", resultList);
    }

    @Test
    @Transactional
    void native_queries_update() {
        Query query = em.createNativeQuery("update course set modified_at=LOCALTIMESTAMP", Course.class);
        int numberOfEffectedRows = query.executeUpdate();
        logger.info("numberOfEffectedRows -> {}", numberOfEffectedRows);
    }
}
