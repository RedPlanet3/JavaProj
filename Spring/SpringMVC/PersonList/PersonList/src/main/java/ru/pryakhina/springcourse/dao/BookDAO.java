package ru.pryakhina.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Book;
import ru.pryakhina.springcourse.models.Person;


import java.util.List;

@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Book> index() {
        return jdbcTemplate.query("SELECT * From Book;",
                new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book newBook) {
        jdbcTemplate.update("INSERT into Bok(name,autor, year) values (?, ?, ?);",
                newBook.getName(), newBook.getAutor(),newBook.getYear());
    }

    public void update(int id, Book upBook) {
        jdbcTemplate.update("UPDATE Book set person_id=?, name=?, birthday=? where id=?;",
                upBook.getPerson().getId(), upBook.getName(), upBook.getAutor(),upBook.getYear(), id);
    }

    public Book show(int id) {
       return jdbcTemplate.query("SELECT * FROM BOOK WHERE id=?;",
                        new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void appoint(Person person, int id, Book upBook) {
        jdbcTemplate.update("UPDATE Book set person_id=?where id=?;",
                person.getId(), id);
    }
    public void backToTheLibrary(int id, Book upBook) {
        jdbcTemplate.update("UPDATE Book set person_id= null where id=?;",
                id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book where id=?;", id);
    }
}
