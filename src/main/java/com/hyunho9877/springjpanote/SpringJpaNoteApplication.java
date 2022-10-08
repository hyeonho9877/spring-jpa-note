package com.hyunho9877.springjpanote;

import com.hyunho9877.springjpanote.entity.Person;
import com.hyunho9877.springjpanote.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringJpaNoteApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaNoteApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            List<Person> result = personJdbcDao.findAll();
            logger.info("All users -> {}", result);
            logger.info("User id 10001 -> {}", personJdbcDao.findById(10001));
            logger.info("User name susan -> {}", personJdbcDao.findByName("susan"));
            logger.info("User location amsterdam -> {}", personJdbcDao.findByLocation("amsterdam"));
            logger.info("Deleting User 10002 -> {}", personJdbcDao.deleteById(10002));
            logger.info("Insert Person 10004 -> {}", personJdbcDao.insert(new Person("hyeonho", "anyang", new Date())));
            logger.info("Update Person 10003 -> {}", personJdbcDao.update(new Person("james", "amsterdam", new Date())));
        };
    }

}
