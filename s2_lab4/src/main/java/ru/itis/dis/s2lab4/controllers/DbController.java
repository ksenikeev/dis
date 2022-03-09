package ru.itis.dis.s2lab4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dis.s2lab4.orm.EntityManagerFactory;

import java.io.IOException;

@Controller
public class DbController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @RequestMapping("/")
    public void writer(java.io.Writer writer) throws IOException {
        writer.write(entityManagerFactory.testDbWork());
    }

}
