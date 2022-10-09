package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

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
        Course course1 = new Course("course1");
        em.persist(course1);
        Course course2 = new Course("course2");
        em.persist(course2);
        em.flush();

        course1.setName("course1 updated");
        course2.setName("course2 updated");


        /*
        attempt to throw DataIntegrityViolationException
        Course courseNull = new Course(null);
        em.persist(courseNull);
        */

        em.refresh(course1);
        em.flush();
    }
}
