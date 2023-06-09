package ru.pryakhina.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book_new {

    private int book_id;
    @NotEmpty(message = "Enter name for book")
    @Size(min = 1, message = "Name shouldt be mim 1 symbl")
    private String name;

    @NotEmpty(message = "Enter autor name or noname")
    @Size(min = 1, message = "Name shouldt be mim 1 symbl")
    private String autor;

    @Min(1)
    private int year;


    public Book_new(String name, String autor, int year) {
        this.name = name;
        this.autor = autor;
        this.year = year;
    }

    public Book_new() {
    }

    public int getId() {
        return book_id;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }


    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public int getYear() {
        return year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
