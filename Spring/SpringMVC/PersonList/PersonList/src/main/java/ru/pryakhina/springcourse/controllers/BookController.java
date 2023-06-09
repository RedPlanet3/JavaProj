//package ru.pryakhina.springcourse.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import ru.pryakhina.springcourse.dao.BookDAO_new;
//import ru.pryakhina.springcourse.models.Book_new;
//import ru.pryakhina.springcourse.models.Person;
//import ru.pryakhina.springcourse.util.PersonValidator;
//
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/books")
//public class BookController {
//    private final BookDAO_new bookDAONew;
//    private final PersonValidator personValidator;
//
//    public BookController(BookDAO_new bookDAONew, PersonValidator personValidator) {
//        this.bookDAONew = bookDAONew;
//
//        this.personValidator = personValidator;
//    }
//
//    @GetMapping()
//    public String index(Model model){
//        model.addAttribute("people", bookDAONew.index());
//        return "/books/index";
//    }
//
//    @GetMapping("/{id}")
//    public String bookId(@PathVariable("id") int id,
//                           Model model){
//        model.addAttribute("books", bookDAONew.show(id));
//        return "/books/show";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id)
//    {
//        model.addAttribute("person", bookDAONew.show(id));
//        return "/books/edit";
//    }
//
//    @PatchMapping("/autor/{id}")
//    public String updateAutor(@ModelAttribute("book") @Valid Book_new bookNew,
//                         @ModelAttribute("person") @Valid Person person,
//                         BindingResult bindingResult,
//                         @PathVariable("id") int id){
////        personValidator.validate(person, bindingResult);
//        if (bindingResult.hasErrors())
//            return "/books/edit";
//        if (person != null)
//            bookDAONew.appoint(person, id, bookNew);
//        else
//            bookDAONew.backToTheLibrary(id, bookNew);
//        return "redirect:/books";
//    }
//
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("book") @Valid Book_new bookNew,
//                              BindingResult bindingResult,
//                              @PathVariable("id") int id){
////        personValidator.validate(bookNew, bindingResult);
//
//        if (bindingResult.hasErrors())
//            return "/books/edit";
//            bookDAONew.update(id, bookNew);
//        return "redirect:/books";
//    }
//
//
//    @GetMapping("/new")
//    public String newPerson(@ModelAttribute("book") Book_new bookNew)
//    {
//        return "/books/new";
//    }
//
////    @PostMapping()
////    public String create(@Valid @ModelAttribute("book") Book_new book,
////                         BindingResult bindingResult) {
//////        personValidator.validate(person, bindingResult);
////
////        if (bindingResult.hasErrors())
////            return "/books/new";
////        bookDAO.save(book);
////        return "redirect:/people";
////    }
//
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id){
//        bookDAONew.delete(id);
//        return "redirect:/people";
//    }
//}
