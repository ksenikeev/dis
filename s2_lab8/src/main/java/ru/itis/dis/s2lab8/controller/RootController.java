package ru.itis.dis.s2lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dis.s2lab8.dto.UserDto;
import ru.itis.dis.s2lab8.models.User;
import ru.itis.dis.s2lab8.repositories.UserRepository;

@Controller
public class RootController {

    @Autowired
    private UserRepository repository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "user");
        return "index";
    }

    @RequestMapping("/save")
    public String result(Model model, UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUserName());

        user = repository.save(user);

        model.addAttribute("user", user);
        return "result";
    }


}
