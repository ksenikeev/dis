package ru.itis.dis.s2lab8.models;

import javax.persistence.*;

import static javax.persistence.InheritanceType.*;

@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
//@MappedSuperclass
public class UserData {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
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
