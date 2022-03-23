package ru.itis.dis.s2lab6.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class User {
    private Long id;
    private String name;
    private String password;
}
