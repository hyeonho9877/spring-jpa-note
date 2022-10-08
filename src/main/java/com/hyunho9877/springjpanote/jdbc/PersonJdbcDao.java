package com.hyunho9877.springjpanote.jdbc;

import com.hyunho9877.springjpanote.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from person where id = ?",
                new BeanPropertyRowMapper<>(Person.class),
                id
        );
    }

    public Person findByName(String name) {
        return jdbcTemplate.queryForObject(
                "select * from person where name = ?",
                new BeanPropertyRowMapper<>(Person.class),
                name
        );
    }

    public Person findByLocation(String location) {
        return jdbcTemplate.queryForObject(
                "select * from person where location = ?",
                new BeanPropertyRowMapper<>(Person.class),
                location
        );
    }

    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete from person where id=?", id
        );
    }

    public int insert(Person person) {
        return jdbcTemplate.update(
                "insert into person values(?,?,?,?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())
        );
    }

    public int update(Person person) {
        return jdbcTemplate.update(
                "update person set name= ?, location = ?, birth_data = ? where id = ?",
                person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()
        );
    }

}
