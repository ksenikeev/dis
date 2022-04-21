package ru.itis.dis.s2lab10.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.dis.s2lab10.model.User;
import ru.itis.dis.s2lab10.model.UserRole;
import ru.itis.dis.s2lab10.model.UserStatus;
import ru.itis.dis.s2lab10.repositories.UserRoleRepository;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailImpl implements UserDetails {

    private User user;

    public UserDetailImpl(User user) {
        this.user = user;

        System.out.println(user != null ? (user.getUserName()  +  ":" + new BCryptPasswordEncoder().matches("admin", user.getPassword())): "user not found");
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> result = new ArrayList<>();

        for(UserRole role : user.getRoles()) result.add(new SimpleGrantedAuthority(role.getName()));
        return result;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return UserStatus.CONFIRMED.equals(user.getStatus());
    }
}