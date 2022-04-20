package ru.itis.dis.s2lab10.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.dis.s2lab10.model.User;
import ru.itis.dis.s2lab10.model.UserRole;
import ru.itis.dis.s2lab10.repositories.UserRepository;
import ru.itis.dis.s2lab10.repositories.UserRoleRepository;
import java.util.List;

@Service(value = "myUserDetailsServise")
public class UserDetailsServiseImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserRoleRepository roleRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        if (user != null) {
            //List<UserRole> roles = roleRepository.findByUser(user.getId());
            //user.setRoles(roles);
            return new UserDetailImpl(user);
        } throw new UsernameNotFoundException("User not found!");

    }
}
