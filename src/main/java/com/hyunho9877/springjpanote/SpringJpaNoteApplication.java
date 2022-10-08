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
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                List<Person> result = personJdbcDao.findAll();
                logger.info("All users -> {}", result);
            }
        };
    }

}
