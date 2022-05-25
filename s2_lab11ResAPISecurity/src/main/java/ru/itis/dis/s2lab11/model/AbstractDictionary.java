package ru.itis.dis.s2lab11.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter@Setter
public abstract class AbstractDictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictGen")
    @SequenceGenerator(name = "dictGen", sequenceName = "dictionary_seq", allocationSize = 1)
    private Long id;

    private String name;

    private String code;
}
