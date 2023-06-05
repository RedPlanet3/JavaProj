package ru.pryakhina.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pryakhina.springcourse.dao.PersonDAO;
import ru.pryakhina.springcourse.models.Person;

@Controller
@RequestMapping("/admin")
public class Admin {

    public Admin(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public final PersonDAO personDAO;


    @GetMapping()
    public String adminPage(Model model, @ModelAttribute("person")Person person){
        model.addAttribute("people", personDAO.index());
        return "/adminPage";
    }

    @PatchMapping("/add")
    public String makeAdmin(@ModelAttribute("person") Person person){
        System.out.println(person.getId());

        return "redirect:/people";
    }
}
