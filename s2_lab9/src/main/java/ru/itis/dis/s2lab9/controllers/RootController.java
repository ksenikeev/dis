package ru.itis.dis.s2lab9.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis.s2lab9.dto.UserDto;
import ru.itis.dis.s2lab9.models.User;
import ru.itis.dis.s2lab9.models.UserData;
import ru.itis.dis.s2lab9.repositories.UserCrudRepository;
import ru.itis.dis.s2lab9.repositories.UserRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RootController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserCrudRepository userCrudRepository;

    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("user", "user");
        model.addAttribute("text", "111");
        return "index";
    }

    @GetMapping("/finduserdata")
    public String findUserData(Model model, @RequestParam("name") String name ) {

        List<UserData> users = userCrudRepository.findUserData(name);

        model.addAttribute("userdata", users);
        return "findUserData";
    }

    @GetMapping("/findbyname")
    public String findUsersByName(Model model, @RequestParam("name") String name ) {
        System.out.println(name);

        List<User> users = userCrudRepository.findByNameUpperCase(name.toUpperCase());

        users.forEach(user -> System.out.println(user.getName()));

        model.addAttribute("users", users);
        return "findByName";
    }

    @GetMapping("/findbynameandid")
    public String findUsersByNameAndId(Model model,
               @RequestParam("name") String name, @RequestParam(required = false, name = "id") Long id) {
        System.out.println(name);

        List<User> users = userCrudRepository.findByNameAndId(name, id);

        users.forEach(user -> System.out.println(user.getName()));

        model.addAttribute("users", users);
        return "findByName";
    }

    @PostMapping(path = "/save")
    public String save(UserDto userDto, Model model) {
        System.out.println(userDto);

        User user = new User();
        user.setName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        UserData userData = new UserData();
        userData.setPassport(userDto.getPassport());
        userData.setEmail(userDto.getEmail());

        user.setUserData(userData);

        user = repository.save(user);

        model.addAttribute("user", user);

        return "result";
    }

    @PostMapping(path = "/save1")
    public String saveAsCRUD(UserDto userDto, Model model) {
        System.out.println(userDto);

        User user = new User();
        user.setName(userDto.getUserName());
        user.setPassword(userDto.getPassword());

        UserData userData = new UserData();
        userData.setPassport(userDto.getPassport());
        userData.setEmail(userDto.getEmail());

        user.setUserData(userData);

        // При использовании атрибута cascade = CascadeType.ALL отделное сохраниение userData не требуется
        //userData = repository.save(userData);

        user = userCrudRepository.save(user);

        model.addAttribute("user", user);

        return "result";
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getAllUsers(@PathVariable("id") Long id) {
        return repository.findById(id);
    }
}
