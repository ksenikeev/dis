package ru.itis.dis.s2lab11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootStartLab11RestSecurity {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootStartLab11RestSecurity.class, args);

        //((CreateDefaultUser)context.getBean("createDefaultUser")).createUser();
    }
}
