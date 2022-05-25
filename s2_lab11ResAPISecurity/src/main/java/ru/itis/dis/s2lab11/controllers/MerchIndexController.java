package ru.itis.dis.s2lab11.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MerchIndexController {

    //@Secured({"ADMIN"})
    @GetMapping("/newmerch")
    public String getIndex(Model model) {
        //model.addAttribute("text", "111");
        return "newmerch";
    }
}
