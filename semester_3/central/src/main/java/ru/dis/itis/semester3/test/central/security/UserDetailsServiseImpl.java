package ru.dis.itis.semester3.test.central.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dis.itis.semester3.test.central.model.User;
import ru.dis.itis.semester3.test.central.repositories.UserRepository;
import ru.dis.itis.semester3.test.central.repositories.UserRoleRepository;

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
