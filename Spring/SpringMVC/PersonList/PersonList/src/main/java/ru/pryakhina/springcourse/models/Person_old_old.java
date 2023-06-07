//package ru.pryakhina.springcourse.models;
//
//
//import javax.validation.constraints.*;
//
//public class Person_old_old {
//    private int id;
//    @NotEmpty(message = "Name should not be empty ")
//    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters ")
//    private String name;
//    @Min(value = 0, message = "Minimun age 0 ")
//    private int age;
//    @NotEmpty(message = "Email should not be empty ")
//    @Email(message = "Email should be valid ")
//    private String email;
//
//
//    public String getAdress() {
//        return adress;
//    }
//
//    public void setAdress(String adress) {
//        this.adress = adress;
//    }
//
//    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your adress should be  in this format: Country, City, Postal Code(6 digits)")
//    private String adress;
//
//    public Person_old_old() {
//    }
//
//    public Person_old_old(int id, String name, int age, String email, String adress) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.email = email;
//        this.adress = adress;
//    }
//
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
