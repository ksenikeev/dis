package ru.itis.dis.lab10restapi.controllers.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageableDTO {

    private Integer page;
    private Integer size;
}
