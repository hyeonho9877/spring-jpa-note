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
        List resultList = em.createQuery("select c from Course c").getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_typed() {
        List<Course> resultList = em.createQuery("select c from Course c", Course.class).getResultList();
        logger.info("select c from course c -> {}", resultList);
    }

    @Test
    void jpql_where() {
        List resultList = em.createQuery("select c from Course c where c.name like '% 100 Steps'").getResultList();
        logger.info("select c from course c -> {}", resultList);
    }
}
