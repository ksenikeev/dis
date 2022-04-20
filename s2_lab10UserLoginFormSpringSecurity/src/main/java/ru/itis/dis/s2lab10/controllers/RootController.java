package ru.itis.dis.s2lab10.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
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
