package ru.itis.dis.s2lab11.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dis.s2lab11.controllers.dto.SignInDto;
import ru.itis.dis.s2lab11.controllers.dto.TokenDto;
import ru.itis.dis.s2lab11.services.SignInService;
import java.nio.file.AccessDeniedException;

@RestController
public class RestSIngnInController {

    @Autowired
    private SignInService service;

    @PostMapping("/restsignin")
    public ResponseEntity<TokenDto> signIn(@RequestBody SignInDto signInDto) throws AccessDeniedException {
        return ResponseEntity.ok(service.signIn(signInDto));
    }
}
