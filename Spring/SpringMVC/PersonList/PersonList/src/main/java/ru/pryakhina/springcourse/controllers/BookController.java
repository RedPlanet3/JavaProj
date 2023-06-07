package ru.pryakhina.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.pryakhina.springcourse.dao.BookDAO;
import ru.pryakhina.springcourse.models.Book;
import ru.pryakhina.springcourse.models.Person;
import ru.pryakhina.springcourse.util.PersonValidator;


import javax.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookDAO bookDAO;
    private final PersonValidator personValidator;

    public BookController(BookDAO bookDAO, PersonValidator personValidator) {
        this.bookDAO = bookDAO;

        this.personValidator = personValidator;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", bookDAO.index());
        return "/books/index";
    }

    @GetMapping("/{id}")
    public String bookId(@PathVariable("id") int id,
                           Model model){
        model.addAttribute("books", bookDAO.show(id));
        return "/books/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("person", bookDAO.show(id));
        return "/books/edit";
    }

    @PatchMapping("/autor/{id}")
    public String updateAutor(@ModelAttribute("book") @Valid Book book,
                         @ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult,
                         @PathVariable("id") int id){
//        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "/books/edit";
        if (person != null)
            bookDAO.appoint(person, id, book);
        else
            bookDAO.backToTheLibrary(id, book);
        return "redirect:/books";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book,
                              BindingResult bindingResult,
                              @PathVariable("id") int id){
//        personValidator.validate(book, bindingResult);

        if (bindingResult.hasErrors())
            return "/books/edit";
            bookDAO.update(id, book);
        return "redirect:/books";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("book") Book book)
    {
        return "/books/new";
    }

//    @PostMapping()
//    public String create(@Valid @ModelAttribute("book") Book book,
//                         BindingResult bindingResult) {
////        personValidator.validate(person, bindingResult);
//
//        if (bindingResult.hasErrors())
//            return "/books/new";
//        bookDAO.save(book);
//        return "redirect:/people";
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/people";
    }
}
