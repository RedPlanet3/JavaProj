//package ru.pryakhina.springcourse.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//import ru.pryakhina.springcourse.dao.PersonDAO_old;
//import ru.pryakhina.springcourse.models.Person;
//
//
//@Component
//public class PersonValidator_old implements Validator {
//
//
//    private final PersonDAO_old personDAO;
//
//    @Autowired
//    public PersonValidator_old(PersonDAO_old personDAO) {
//        this.personDAO = personDAO;
//    }
//
//    @Override
//    public boolean supports(Class<?> aClass) {
//        return Person.class.equals((aClass));
//    }
//
//    @Override
//    public void validate(Object o, Errors errors) {
//        Person person = (Person) o;
//
//        if (personDAO.show(person.getName()).isPresent()){
//            errors.rejectValue("email", "", "This email is allready taken");
//        }
//    }
//}
