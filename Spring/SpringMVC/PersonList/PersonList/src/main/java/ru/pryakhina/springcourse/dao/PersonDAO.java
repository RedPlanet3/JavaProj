package ru.pryakhina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
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
        return jdbcTemplate.query("SELECT * From Person;", new BeanPropertyRowMapper<>(Person.class));
    }

    public Optional<Person> show(String email) {
    return jdbcTemplate.query("SELECT * From Person where email=?",
        new Object[]{email}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * From Person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person){

        jdbcTemplate.update("INSERT INTO Person(name, age, email, adress) VALUES(?, ?, ?, ?);",
                person.getName(), person.getAge(), person.getEmail(), person.getAdress());
    }

    public void update(int id, Person upPerson){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=?, adress=? where id=?;",
                upPerson.getName(), upPerson.getAge(), upPerson.getEmail(),upPerson.getAdress(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person where id=?;", id);
    }

    // test add

    public void testMultipleUpdate(){
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();
        for (Person person: people) {
            jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?, ?);",
                    person.getName(), person.getAge(), person.getEmail(), person.getAdress());
        }
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }

    public List<Person> create1000People(){
        List<Person> people = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++)
            people.add(new Person(i, "TName" + i, 30, "test" + i + "@", "adress"));
        return people;
    }


    public void testBatchUpdate() {
        List<Person> people = create1000People();

        long before = System.currentTimeMillis();
        jdbcTemplate.batchUpdate("INSERT INTO Person VALUES(?, ?, ?, ?, ?);",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setInt(1, people.get(i).getId());
                        preparedStatement.setString(2, people.get(i).getName());
                        preparedStatement.setInt(3, people.get(i).getAge());
                        preparedStatement.setString(4, people.get(i).getEmail());
                        preparedStatement.setString(5, people.get(i).getAdress());
                    }

                    @Override
                    public int getBatchSize() {
                        return people.size();
                    }
                });
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
