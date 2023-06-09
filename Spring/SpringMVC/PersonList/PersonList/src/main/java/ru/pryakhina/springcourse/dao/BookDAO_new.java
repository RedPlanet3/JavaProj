package ru.pryakhina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Book_new;
import ru.pryakhina.springcourse.models.Person;


import java.util.List;

@Component
public class BookDAO_new {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO_new(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book_new> index() {
        return jdbcTemplate.query("SELECT * From Book;",
                new BeanPropertyRowMapper<>(Book_new.class));
    }

    public void save(Book_new newBookNew) {
        jdbcTemplate.update("INSERT into Bok(name,autor, year) values (?, ?, ?);",
                newBookNew.getName(), newBookNew.getAutor(), newBookNew.getYear());
    }

    public void update(int id, Book_new upBookNew) {
        jdbcTemplate.update("UPDATE Book set person_id=?, name=?, birthday=? where id=?;",
                upBookNew.getName(), upBookNew.getAutor(), upBookNew.getYear(), id);
    }

    public Book_new show(int id) {
       return jdbcTemplate.query("SELECT * FROM BOOK WHERE id=?;",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Book_new.class))
                .stream().findAny().orElse(null);
    }

    public void appoint(Person person, int id, Book_new upBookNew) {
        jdbcTemplate.update("UPDATE Book set person_id=?where id=?;",
                person.getId(), id);
    }
    public void backToTheLibrary(int id, Book_new upBookNew) {
        jdbcTemplate.update("UPDATE Book set person_id= null where id=?;",
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book where id=?;", id);
    }
}
