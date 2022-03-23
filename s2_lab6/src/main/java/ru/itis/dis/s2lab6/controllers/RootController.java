package ru.itis.dis.s2lab6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.dis.s2lab6.models.User;
import ru.itis.dis.s2lab6.repositories.UserRepository;
import java.util.List;

@Controller
public class RootController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", User.builder().id(4l).name("user 4").build());
        return "index";
    }

    @RequestMapping("/allusers")
    @ResponseBody
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User getAllUsers(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(User.builder().build());
    }
}
