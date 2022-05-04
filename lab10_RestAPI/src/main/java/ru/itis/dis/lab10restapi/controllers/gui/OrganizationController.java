package ru.itis.dis.lab10restapi.controllers.gui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrganizationController {

    @GetMapping("/organizations")
    public String orgs(Model model) {
        return "orgs";
    }

}
