package com.example.springbootjwt.service;

import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.security.Key;
import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class CustomJwtKey implements Key {

    @Value("${app.jwt.secret}")
    private String SECRET_KEY = "";

    @Override
    public String getAlgorithm() {
        return SignatureAlgorithm.HS256.getJcaName();
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return SECRET_KEY.getBytes(UTF_8);
    }
}
