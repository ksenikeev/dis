package ru.itis.dis.s2lab7.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personIdGenerator")
    @SequenceGenerator(name = "personIdGenerator", sequenceName = "user_seq", allocationSize=1)
    private Long id;

    private String name;

    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private UserData userData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
