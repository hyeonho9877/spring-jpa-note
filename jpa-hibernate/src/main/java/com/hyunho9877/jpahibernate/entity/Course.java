package com.hyunho9877.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.time.LocalDateTime;

@Entity
/*@NamedQueries(value = {
        @NamedQuery(name = "query_get_all_courses", query = "select c from Course c"),
        @NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.name like '% 100 Steps'")
})*/
@NamedQuery(name = "query_get_all_courses", query = "select c from Course c")
@NamedQuery(name = "query_get_100_step_courses", query = "select c from Course c where c.name like '% 100 Steps'")
//@Table(name = "CourseDetails")
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    //@Column(name = "full_name", nullable = false)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime modifiedAt;

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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
