package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
public class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    public void criteria_query() {
        // select c from course c
        // 1. use criteria builder to create a criteria query
        // returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. define predicates etc using criteria building

        // 4. add predicates etc to the criteria query

        // 5. build the typed query using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    public void criteria_query_courses_having_100Steps() {
        // select c from course c where c.name like '%100 Steps'"
        // 1. use criteria builder to create a criteria query
        // returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. define predicates etc using criteria building
        Predicate like = cb.like(courseRoot.get("name"), "%50 Steps");

        // 4. add predicates etc to the criteria query
        cq.where(like);

        // 5. build the typed query using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    public void criteria_query_courses_with_students() {
        // select c from course c where c.students is empty

        // 1. use criteria builder to create a criteria query
        // returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. define predicates etc using criteria building
        Predicate empty = cb.isEmpty(courseRoot.get("students"));

        // 4. add predicates etc to the criteria query
        cq.where(empty);

        // 5. build the typed query using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    public void criteria_query_join() {
        // select c from course c join c.students s
        // 1. use criteria builder to create a criteria query
        // returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. define predicates etc using criteria building
        Join<Object, Object> join = courseRoot.join("students");

        // 4. add predicates etc to the criteria query

        // 5. build the typed query using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();
        logger.info("result -> {}", resultList);
    }

    @Test
    public void criteria_query_left_join() {
        // select c from course c join c.students s
        // 1. use criteria builder to create a criteria query
        // returning the expected result object
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        // 2. define roots for tables which are involved in the query
        Root<Course> courseRoot = cq.from(Course.class);

        // 3. define predicates etc using criteria building
        Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

        // 4. add predicates etc to the criteria query

        // 5. build the typed query using the entity manager and criteria query
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List<Course> resultList = query.getResultList();
        logger.info("result -> {}", resultList);
    }
}
