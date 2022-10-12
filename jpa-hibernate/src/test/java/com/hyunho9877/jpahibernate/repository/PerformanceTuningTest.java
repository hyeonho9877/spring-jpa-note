package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
class PerformanceTuningTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    @Autowired
    EntityManager em;

    // how to solve n+1 problem
    // 1. make lazy fetch to eager fetch (not recommended)

    @Test
    @Transactional
    void creatingNPlusOneProblem() {
        List<Course> courses = em.
                createNamedQuery("query_get_all_courses", Course.class)
                .getResultList();

        for (Course course : courses) {
            logger.info("course -> {}, students -> {}", course, course.getStudents());
        }
    }

    // 2. add Hint to query -> EntityGraph

    @Test
    @Transactional
    void solvingNPLusOneProblem_EntityGraph() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
        entityGraph.addSubgraph("students");
        List<Course> courses = em.
                createNamedQuery("query_get_all_courses", Course.class)
                .setHint("javax.persistence.loadgraph", entityGraph)
                .getResultList();

        for (Course course : courses) {
            logger.info("course -> {}, students -> {}", course, course.getStudents());
        }
    }

    // 3. Join Fetch
    @Test
    @Transactional
    void creatingNPlusOneProblem_join_fetch() {
        List<Course> courses = em.
                createNamedQuery("query_get_100_step_courses_join_fetch", Course.class)
                .getResultList();

        for (Course course : courses) {
            logger.info("course -> {}, students -> {}", course, course.getStudents());
        }
    }
}