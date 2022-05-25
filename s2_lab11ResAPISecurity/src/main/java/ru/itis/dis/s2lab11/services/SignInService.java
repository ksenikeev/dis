package ru.itis.dis.s2lab11.services;

import ru.itis.dis.s2lab11.controllers.dto.SignInDto;
import ru.itis.dis.s2lab11.controllers.dto.TokenDto;

import java.nio.file.AccessDeniedException;

public interface SignInService {
    TokenDto signIn(SignInDto signInDto) throws AccessDeniedException;
}
