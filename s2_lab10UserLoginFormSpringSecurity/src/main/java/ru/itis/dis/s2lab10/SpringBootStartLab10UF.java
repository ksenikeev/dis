package ru.itis.dis.s2lab10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.dis.s2lab10.services.CreateDefaultUser;

@SpringBootApplication
public class SpringBootStartLab10UF {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootStartLab10UF.class, args);

        //((CreateDefaultUser)context.getBean("createDefaultUser")).createUser();
    }
}
