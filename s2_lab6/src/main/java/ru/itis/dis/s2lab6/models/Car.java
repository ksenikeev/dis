package ru.itis.dis.s2lab6.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {
    private String number;
    private String model;
}
