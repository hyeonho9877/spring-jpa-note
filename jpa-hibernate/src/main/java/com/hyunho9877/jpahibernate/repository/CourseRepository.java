package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import com.hyunho9877.jpahibernate.entity.Review;
import com.hyunho9877.jpahibernate.entity.ReviewRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager em;

    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course) {
        if(course.getId()==null) em.persist(course);
        else em.merge(course);

        return course;
    }

    public void playWithEntityManager() {
        Course course = new Course("course 1");
        em.persist(course);

        Course courseResult = findById(10001L);
        courseResult.setName("course updated");
    }

    public void addHardcodedReviewForCourse() {
        //get course 10003
        Course course = em.find(Course.class, 10003L);
        logger.info("course reviews -> {}", course.getReviews());
        //add 2 reviews to it
        Review review = new Review(ReviewRating.FIVE, "great hands on stuff");
        Review review1 = new Review(ReviewRating.FIVE, "hatsoff");
        //course.addReview(); setting relationship
        course.addReview(review);
        review.setCourse(course);
        course.addReview(review1);
        review1.setCourse(course);
        //save it to database

        em.persist(review);
        em.persist(review1);
    }

    public void addReviewForCourse(Long courseID, List<Review> reviews) {
        //get course 10003
        Course course = em.find(Course.class, courseID);
        logger.info("course reviews -> {}", course.getReviews());
        for (Review review : reviews) {
            course.addReview(review);
            review.setCourse(course);
            em.persist(review);
        }
    }




}
