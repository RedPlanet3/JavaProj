package ru.pryakhina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * From Person;", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * From Person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){

        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?);",
                person.getName(), person.getAge(), person.getEmail());
    }

    public void update(int id, Person upPerson){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? where id=?;",
                upPerson.getName(), upPerson.getAge(), upPerson.getEmail(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person where id=?;", id);
    }
}
