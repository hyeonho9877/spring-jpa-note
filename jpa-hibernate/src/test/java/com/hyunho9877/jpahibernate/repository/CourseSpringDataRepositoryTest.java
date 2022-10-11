package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseSpringDataRepository repository;

    @Test
    void findById_coursePresent() {
        Optional<Course> course = repository.findById(10001L);
        logger.info("course -> {}", course.isPresent());
        assertTrue(course.isPresent());
    }

    @Test
    void findById_courseNotPresent() {
        Optional<Course> course = repository.findById(20001L);
        assertFalse(course.isPresent());
    }

    @Test
    void playAround() {
        /*Course course = new Course("course");
        repository.save(course);
        course.setName("course updated");
        repository.save(course);*/

        logger.info("courses -> {}", repository.findAll());
        logger.info("count -> {}", repository.count());
    }

    @Test
    void sort() {
        Sort name = Sort.by(Sort.Direction.ASC, "name");
        logger.info("sort -> {}", repository.findAll(name));
    }

}