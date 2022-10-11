package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import com.hyunho9877.jpahibernate.entity.Student;
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

    @Test
    void jpql_courses_without_students() {
        List<Course> resultList = em.createQuery("select c from Course c where c.students is empty", Course.class).getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    void jpql_courses_with_at_least_2_students() {
        List<Course> resultList = em.createQuery("select c from Course c where size(c.students) >= 2", Course.class).getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    void jpql_courses_ordered_By_students() {
        List<Course> resultList = em.createQuery("select c from Course c order by size(c.students) desc", Course.class).getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    void jpql_courses_ordered_By_students_desc() {
        List<Course> resultList = em.createQuery("select c from Course c order by size(c.students) desc", Course.class).getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    void jpql_students_with_passport_in_a_certain_pattern() {
        List<Student> resultList = em.createQuery("select s from Student s where s.passport.number like 'E%'", Student.class).getResultList();
        logger.info("result -> {}", resultList);
    }


    // like
    //between 100 and 1000
    //is null
    //upper, lower, trim, length
}
