package com.hyunho9877.jpahibernate;

import com.hyunho9877.jpahibernate.entity.Review;
import com.hyunho9877.jpahibernate.repository.CourseRepository;
import com.hyunho9877.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class JpaHibernateApplication {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            ArrayList<Review> reviews = new ArrayList<>();
            //studentRepository.saveStudentWithPassport();
            //courseRepository.addHardcodedReviewForCourse();
            reviews.add(new Review("5", "great hands on stuff"));
            reviews.add(new Review("5", "hatsoff"));
            courseRepository.addReviewForCourse(10003L, reviews);
        };
    }

}
