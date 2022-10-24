package com.example.springbootjwt.security;

import com.example.springbootjwt.dto.UserDto;
import com.example.springbootjwt.enums.TokenBody;
import com.sun.istack.NotNull;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtTokenHelper {
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour

    public static final String BEARER = "Bearer";

    public static final String AUTHORIZATION = "Authorization";

    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    public String generateAccessTokenFromUserDto(UserDto user) {

//        return Jwts.builder()
//                .setIssuer("Stormpath")
//                .setSubject("msilverman")
//                .claim("name", "Micah Silverman")
//                .claim("scope", "admins")
//                // Fri Jun 24 2016 15:33:42 GMT-0400 (EDT)
//                .setIssuedAt(new Date())
//                // Sat Jun 24 2116 15:33:42 GMT-0400 (EDT)
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
//                .signWith(customJwtKey)
////                .signWith(SECRET_KEY)
//                .setSubject(String.format("%s,%s", user.getId(), user.getUsername()))
////                .setIssuer("jason")
////                .setIssuedAt(new Date())
////                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
////                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//                .compact();

        return Jwts.builder()
                .claim(TokenBody.USERNAME.getName(), user.getUsername())
//                .claim("email", "jane@example.com")
//                .setSubject("jane")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    // TODO: refactor this
    public boolean validateAccessToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException ex) {
            log.error("JWT expired", ex.getMessage());
        } catch (IllegalArgumentException ex) {
            log.error("Token is null, empty or only whitespace", ex.getMessage());
        } catch (MalformedJwtException ex) {
            log.error("JWT is invalid", ex);
        } catch (UnsupportedJwtException ex) {
            log.error("JWT is not supported", ex);
        } catch (SignatureException ex) {
            log.error("Signature validation failed");
        }

        return false;
    }

    public String getUsernameFromJwtToken(String token) {
        return parseJwtBody(token).get(TokenBody.USERNAME.getName(), String.class);
    }

    private Claims parseJwtBody(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateAuthorizationHeaderWithJwt(@NotNull String jwtToken) {
        return BEARER + " " + jwtToken;
    }

    public String extractTokenFromAuthorizationString(@NotNull String stringWithBearer) {
        String[] headerArray = stringWithBearer.split(BEARER);

        return (headerArray.length < 2) ? "" : headerArray[1].trim();
    }
}