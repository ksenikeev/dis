package ru.itis.dis.s2lab8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itis.dis.s2lab8.models.User;
import ru.itis.dis.s2lab8.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
public class SpringBootStartLab8 {
    public static void main(String[] args) {
        ApplicationContext context =
            SpringApplication.run(SpringBootStartLab8.class, args);

        UserRepository repository = context.getBean(UserRepository.class);

        List<User> lst = repository.findAll();
        User user = new User();
        user.setName("asdadasd");
        repository.save(user);
    }
}
