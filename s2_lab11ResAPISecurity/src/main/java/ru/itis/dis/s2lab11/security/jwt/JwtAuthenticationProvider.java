package ru.itis.dis.s2lab11.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.itis.dis.s2lab11.model.User;
import ru.itis.dis.s2lab11.security.UserDetailImpl;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JwtAuthentication tokenAuthentication = (JwtAuthentication) authentication;
        String token = authentication.getName();

        Claims claims;
        try{
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Bad token");
        }

        User user = new User();
        //claims.get("sub", String.class);
        //claims.get("role", String.class);
        //claims.get("name", String.class);

        UserDetails userDetails = new UserDetailImpl(user);

        authentication.setAuthenticated(true);

        tokenAuthentication.setUserDetails(userDetails);

        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.equals(authentication);
    }
}
