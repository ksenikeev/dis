package ru.dis.itis.semester3.test.central.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organizationGen")
    @SequenceGenerator(name = "organizationGen", sequenceName = "organization_seq",allocationSize = 1)
    private Long id;

    private String name;

    @ManyToOne
    private Country country;
}
