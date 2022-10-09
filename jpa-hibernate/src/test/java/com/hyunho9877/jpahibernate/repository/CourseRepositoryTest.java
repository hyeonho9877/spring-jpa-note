package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findById_basic() {
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());
    }
}