package com.hyunho9877.jpahibernate.repository;

import com.hyunho9877.jpahibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);

    Long countByName(String name);

    @Query("select c from Course c where c.name like '% 50 Steps'")
    List<Course> courseWith50StepsInName();

    @Query(value = "select * from course where name like '% 50 Steps'", nativeQuery = true)
    List<Course> courseWith50StepsInNameUsingNativeQuery();
}
