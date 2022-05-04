package ru.itis.dis.lab10restapi.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
    private Long id;
    private String name;
}
