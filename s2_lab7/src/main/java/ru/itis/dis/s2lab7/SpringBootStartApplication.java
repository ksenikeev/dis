package ru.itis.dis.s2lab7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootStartApplication {
    public static void main(String[] args) {
        ApplicationContext context =
                SpringApplication.run(SpringBootStartApplication.class, args);

        
    }
}
