package ru.dis.itis.semester3.test.central.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    //@Secured({"ADMIN"})
    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("text", "111");
        return "index";
    }
}
