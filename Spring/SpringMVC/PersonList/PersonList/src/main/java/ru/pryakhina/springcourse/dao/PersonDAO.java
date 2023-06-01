package ru.pryakhina.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Ben", 24, "ben@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Tom", 52, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "David", 18, "david@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kate", 34, "kate@mail.ru"));
    }

    public List<Person> index()
    {
        return people;
    }

    public Person show(int id)
    {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse((null));
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person upPerson){
        Person personToUpdate = show(id);
        personToUpdate.setName(upPerson.getName());
        personToUpdate.setAge(upPerson.getAge());
        personToUpdate.setEmail(upPerson.getEmail());
    }

    public void delete(int id){
       people.removeIf(p -> p.getId() == id);
    }
}
