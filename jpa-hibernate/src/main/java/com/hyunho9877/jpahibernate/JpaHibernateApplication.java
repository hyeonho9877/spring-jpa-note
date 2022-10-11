package com.hyunho9877.jpahibernate;

import com.hyunho9877.jpahibernate.entity.FullTimeEmployee;
import com.hyunho9877.jpahibernate.entity.PartTimeEmployee;
import com.hyunho9877.jpahibernate.repository.CourseRepository;
import com.hyunho9877.jpahibernate.repository.EmployeeRepository;
import com.hyunho9877.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class JpaHibernateApplication {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
//            ArrayList<Review> reviews = new ArrayList<>();
            //studentRepository.saveStudentWithPassport();
            //courseRepository.addHardcodedReviewForCourse();
//            reviews.add(new Review("5", "great hands on stuff"));
//            reviews.add(new Review("5", "hatsoff"));
//            courseRepository.addReviewForCourse(10003L, reviews);
//            studentRepository.insertCourseToStudent(20001L, new Course("MSA in 100 Steps"));
            employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
            employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
            logger.info("employees -> {}", employeeRepository.findAll());
        };
    }

}
