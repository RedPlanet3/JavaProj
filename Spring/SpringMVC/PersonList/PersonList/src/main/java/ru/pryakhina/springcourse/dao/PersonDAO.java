package ru.pryakhina.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.pryakhina.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1234";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    private List<Person> people;

//    {
//        people = new ArrayList<>();
//        people.add(new Person(++PEOPLE_COUNT, "Ben", 24, "ben@mail.ru"));
//        people.add(new Person(++PEOPLE_COUNT, "Tom", 52, "tom@mail.ru"));
//        people.add(new Person(++PEOPLE_COUNT, "David", 18, "david@mail.ru"));
//        people.add(new Person(++PEOPLE_COUNT, "Kate", 34, "kate@mail.ru"));
//    }

    public List<Person> index()
    {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person;";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return people;
    }

    public Person show(int id)
    {
        Person person = null;
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "SELECT * FROM person WHERE id = ?;"
                    );
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void save(Person person){

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "INSERT INTO Person VALUES(1, ?, ?, ?);");

            preparedStatement.setString(1, person.getName());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person upPerson){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "UPDATE Person SET name=?, age=?, email=? where id=?;"
                    );
            preparedStatement.setString(1, upPerson.getName());
            preparedStatement.setInt(2, upPerson.getAge());
            preparedStatement.setString(3, upPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(
                            "DELETE FROM Person where id=?;"
                    );
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
