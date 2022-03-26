package ru.itis.dis.s2lab6.models;

public class UserBuilder {
     Long id;
     String name;
     String password;

    public UserBuilder id(Long id) {

        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);
        return user;
    }
}
