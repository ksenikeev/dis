package ru.itis.dis.s2lab7.models;

import javax.persistence.*;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "udIdGenerator")
    @SequenceGenerator(name = "udIdGenerator", sequenceName = "userdate_seq", allocationSize=1)
    private Long id;

    private String passport;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
