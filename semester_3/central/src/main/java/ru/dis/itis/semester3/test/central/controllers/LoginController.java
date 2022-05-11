package ru.dis.itis.semester3.test.central.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dis.itis.semester3.test.central.controllers.dto.LoginFormDto;
import ru.dis.itis.semester3.test.central.repositories.UserRepository;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "loginform";
    }

    @PostMapping("/usercheck")
    public String loginForm(HttpServletRequest request, Model model, LoginFormDto form) {

        System.out.println(form.getUsername());
        try {
            request.login(form.getUsername(), form.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";
    }
}
