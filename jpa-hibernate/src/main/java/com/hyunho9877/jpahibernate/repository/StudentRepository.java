package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import com.hyunho9877.jpahibernate.entity.Passport;
import com.hyunho9877.jpahibernate.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager em;

    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student) {
        if(student.getId()==null) em.persist(student);
        else em.merge(student);

        return student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z1234");
        em.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        em.persist(student);
    }

    public void insertHardCodedStudentAndCourse() {
        Student student = new Student("Jack");
        Course course = new Course("MSA in 100 Steps");

        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        // em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course) {
        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);

        // em.persist(student);
    }

    public void insertCourseToStudent(Long studentID, Course course) {
        Student student = em.find(Student.class, studentID);
        em.persist(course);
        student.addCourse(course);
    }
}
