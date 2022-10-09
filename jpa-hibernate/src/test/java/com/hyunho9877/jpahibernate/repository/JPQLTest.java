package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
public class JPQLTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void jpql_basic() {
        List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_typed() {
        List<Course> resultList = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_where() {
        List resultList = em.createNamedQuery("query_get_100_step_courses").getResultList();
        logger.info("select c from course c -> {}", resultList);
    }
}
