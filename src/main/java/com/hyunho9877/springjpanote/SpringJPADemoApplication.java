package com.hyunho9877.springjpanote;

import com.hyunho9877.springjpanote.entity.Person;
import com.hyunho9877.springjpanote.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringJPADemoApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJpaRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJPADemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            logger.info("User id 10001 -> {}", repository.findById(10001));
            logger.info("Insert Person 10004 -> {}", repository.insert(new Person("hyeonho", "anyang", new Date())));
            repository.deleteById(10002);
            logger.info("All users - > {}", repository.findAll());
            /*List<Person> result = repository.findAll();
            logger.info("All users -> {}", result);
            logger.info("User name susan -> {}", repository.findByName("susan"));
            logger.info("User location amsterdam -> {}", repository.findByLocation("amsterdam"));
            logger.info("Deleting User 10002 -> {}", repository.deleteById(10002));
            logger.info("Update Person 10003 -> {}", repository.update(new Person("james", "amsterdam", new Date())));*/
        };
    }

}
