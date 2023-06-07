//package ru.pryakhina.library.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ru.pryakhina.library.dao.PersonDAO_old;
//import ru.pryakhina.library.models.Person_old;
//
//@Controller
//@RequestMapping("/admin")
//public class Admin {
//
//    public Admin(PersonDAO_old personDAO) {
//        this.personDAO = personDAO;
//    }
//
//    public final PersonDAO_old personDAO;
//
//
//    @GetMapping()
//    public String adminPage(Model model, @ModelAttribute("person") Person_old person){
//        model.addAttribute("people", personDAO.index());
//        return "/adminPage";
//    }
//
//    @PatchMapping("/add")
//    public String makeAdmin(@ModelAttribute("person") Person_old person){
//        System.out.println(person.getId());
//
//        return "redirect:/people";
//    }
//}
