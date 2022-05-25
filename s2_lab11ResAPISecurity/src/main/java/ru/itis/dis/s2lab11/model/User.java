package ru.itis.dis.s2lab11.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Getter@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGen")
    @SequenceGenerator(name = "userGen", sequenceName = "users_seq",allocationSize = 1)
    private Long id;

    private String userName;

    private String password;

    @ManyToMany(fetch=FetchType.LAZY)
    private List<UserRole> roles;

    @ManyToOne
    private Organization organization;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.NOT_CONFIRMED;
}
