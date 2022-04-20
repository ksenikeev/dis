package ru.itis.dis.s2lab10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RootController {

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("text", "111");
        return "index";
    }
}
