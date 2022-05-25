package ru.itis.dis.s2lab11.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itis.dis.s2lab11.controllers.dto.SignInDto;
import ru.itis.dis.s2lab11.controllers.dto.TokenDto;

import java.nio.file.AccessDeniedException;

@Service
public class SignInServiceImpl implements SignInService {

    @Value("${jwt.secret}")
    private String secretCode;

    public TokenDto signIn(SignInDto signInDto) throws AccessDeniedException {
        System.out.println(secretCode);
        if (true) {
            String token = Jwts.builder()
                    .setSubject("1")
                    .claim("name", "Kamil")
                    .claim("role", "SYSTEM")
                    .signWith(SignatureAlgorithm.HS256, secretCode)
                    .compact();
            return new TokenDto(token);
        } else {
            throw new AccessDeniedException("Wrogg username or password!");
        }

    }
}
