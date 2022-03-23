package ru.itis.dis.s2lab6.repositories;

import org.springframework.stereotype.Repository;
import ru.itis.dis.s2lab6.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> findAll () {
        if(users.size() == 0) {
            users.add(User.builder().id(1l).name("user 1").password("1").build());
            users.add(User.builder().id(2l).name("user 2").password("2").build());
            users.add(User.builder().id(3l).name("user 3").password("3").build());
        }
        return users;
    }

    public Optional<User> findById(Long id) {
        return users.stream().filter(u->id.equals(u.getId())).findFirst();
    }
}
