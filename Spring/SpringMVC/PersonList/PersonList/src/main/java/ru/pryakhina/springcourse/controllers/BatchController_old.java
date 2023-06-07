//package ru.pryakhina.springcourse.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ru.pryakhina.springcourse.dao.PersonDAO_old;
//
//@Controller
//@RequestMapping("/test-batch-update")
//public class BatchController_old {
//
//    private final PersonDAO_old personDAO;
//
//    public BatchController_old(PersonDAO_old personDAO) {
//        this.personDAO = personDAO;
//    }
//
//
//    @GetMapping()
//    public String index(){
//        return "/batch/index";
//    }
//
////    @GetMapping("/without")
////    public String withoutBatch(){
////        personDAO.testMultipleUpdate();
////        return "redirect:/people";
////    }
////
////    @GetMapping("/with")
////    public String withBatch(){
////        personDAO.testBatchUpdate();
////        return "redirect:/people";
////    }
//}
