package ru.pryakhina.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int person_id;
    @NotEmpty(message = "Name should be full")
    @Size(min = 2, max = 200, message = "Name should be between 2 and 200 characters")
    private String name;

    @Min(value = 1900, message = "Birthday must be more than 1900")
    private int birthday;

    public Person() {
    }

    public Person(int person_id, String name, int birthday) {
        this.person_id = person_id;
        this.name = name;
        this.birthday = birthday;
    }

    public int getId() {
        return person_id;
    }

    public void setId(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
}
