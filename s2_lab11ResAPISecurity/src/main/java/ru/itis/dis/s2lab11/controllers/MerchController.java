package ru.itis.dis.s2lab11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis.s2lab11.model.Merch;
import ru.itis.dis.s2lab11.services.MerchService;

import java.util.List;

@RestController
public class MerchController {

    @Autowired
    private MerchService merchService;


    //@Secured({"ADMIN"})
    //@PreAuthorize("permitAll()")
    //@PreAuthorize("isAuthentificated()")
    //@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping("/merch")
    public List<Merch> getAllMerch(Model model, @RequestParam("name") String name) {
        return merchService.findByName(name);
    }
}
