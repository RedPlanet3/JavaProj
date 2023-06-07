package ru.pryakhina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Person;


import java.util.List;
import java.util.Optional;


@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * From person;",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person newPerson) {
        jdbcTemplate.update("INSERT into Person(name, birthday) values (?, ?);",
                newPerson.getName(), newPerson.getBirthday());
    }

    public void update(int id, Person upPerson) {
        jdbcTemplate.update("UPDATE Person set name=?, birthday=? where person_id=?;",
                upPerson.getName(), upPerson.getBirthday(), id);
    }


    public Person show(int id) {
        return jdbcTemplate.query("SELECT * From Person where person_id=?;",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public Optional<Person> show(String name) {
        return jdbcTemplate.query("SELECT * From Person where name=?",
                        new Object[]{name}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person where person_id=?;", id);
    }
}
