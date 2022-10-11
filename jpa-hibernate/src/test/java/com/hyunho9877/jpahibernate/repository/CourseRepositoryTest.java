package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import com.hyunho9877.jpahibernate.entity.Review;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository repository;

    @Autowired
    EntityManager em;

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

    @Test
    @DirtiesContext
    void deleteById_basic() {
        repository.deleteById(10002L);
        assertNull(repository.findById(10002L));
    }

    @Test
    @DirtiesContext
    void save_basic() {
        //get a course
        Course course = repository.findById(10001L);
        assertEquals("JPA in 50 Steps", course.getName());

        //update details
        course.setName("JPA in 50 Steps - Updated");
        repository.save(course);

        //check
        Course course1 = repository.findById(10001L);
        assertEquals("JPA in 50 Steps - Updated", course1.getName());
    }

    @Test
    @DirtiesContext
    void playWithEntityManager() {
        repository.playWithEntityManager();
    }

    @Test
    @Transactional
    void retrieveReviewsForCourse() {
        Course course = repository.findById(10001L);
        logger.info("{}", course.getReviews());
    }

    @Test
    @Transactional
    void retrieveCourseForReview() {
        Review review = em.find(Review.class, 50001L);
        logger.info("{}", review.getCourse());
    }
}