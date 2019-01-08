package Model;

import enums.client;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class jwt {
    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(Account account) {
        Date date = new Date();
        Long time = date.getTime();
        // The expirationTime is set for 20 minutes;
        Date expirationTime = new Date(time + 1200000);

        String jwtToken = Jwts.builder().setSubject(account.getEmail())
                .claim("username", account.getEmail())
                .claim("role", account.getRole())
                .setIssuedAt(new Date())
                .setExpiration(expirationTime)
                .signWith(key).compact();

        return jwtToken;
    }

}