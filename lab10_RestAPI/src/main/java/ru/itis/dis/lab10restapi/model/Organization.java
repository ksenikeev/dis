package ru.itis.dis.lab10restapi.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter @Setter
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orgGen")
    @SequenceGenerator(  name = "orgGen", sequenceName = "org_seq",allocationSize = 1  )
    private Long id;

    private String name;

    private String country;

    private String address;

    private String innerId;
}
