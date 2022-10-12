package com.hyunho9877.jpahibernate.entity;

import com.hyunho9877.jpahibernate.config.CachingConfig;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
/*@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.name like '% 100 Steps'")
})*/
@NamedQuery(name = "query_get_all_courses", query = "select c from Course c")
@NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.name like '% 100 Steps'")
//@Table(name = "CourseDetails")
@Cacheable
@org.hibernate.annotations.Cache(region = CachingConfig.DB_CACHE, usage = CacheConcurrencyStrategy.READ_WRITE)
@SQLDelete(sql = "update course set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name = "full_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

    private boolean isDeleted;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
