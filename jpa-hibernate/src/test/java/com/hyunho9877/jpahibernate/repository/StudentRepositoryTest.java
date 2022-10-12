package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Address;
import com.hyunho9877.jpahibernate.entity.Course;
import com.hyunho9877.jpahibernate.entity.Passport;
import com.hyunho9877.jpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository repository;

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("student passport -> {}", student.getPassport());
    }


    @Test
    @Transactional
    void retrievePassportAndAssociatedStudent() {
        Passport passport = em.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }


    @Test
    @Transactional
    void retrieveStudentAndCourses() {
        Student student = em.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }

    @Test
    @Transactional
    void retrieveCourseAndStudents() {
        Course course = em.find(Course.class, 10001L);
        logger.info("course -> {}", course);
        logger.info("students -> {}", course.getStudents());
    }

    @Test
    @Transactional
    void setAddressDetails() {
        Student student = em.find(Student.class, 20001L);
        student.setAddress(new Address("line1", "line2", "city"));
        em.flush();
        logger.info("student -> {}", student);
        logger.info("student passport -> {}", student.getPassport());
    }
}