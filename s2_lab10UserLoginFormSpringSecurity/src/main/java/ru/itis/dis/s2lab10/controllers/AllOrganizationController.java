package ru.itis.dis.s2lab10.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllOrganizationController {
    //@Secured({"ADMIN"})
    //@PreAuthorize("permitAll()")
    //@PreAuthorize("isAuthentificated()")
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/org")
    public String getAllOrganization(Model model) {
        return "allorg";
    }
}
