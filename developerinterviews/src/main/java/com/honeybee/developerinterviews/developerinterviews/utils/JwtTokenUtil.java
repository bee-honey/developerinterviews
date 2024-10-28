package com.honeybee.developerinterviews.developerinterviews.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
    private SecretKey key;

    public SecretKey generateKey() {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512); // Generate a secure random secret key

        //Check the key
//        String base64Key = java.util.Base64.getEncoder().encodeToString(key.getEncoded());
//        System.out.println("Secure HS512 key: " + base64Key);
        System.out.println("NKK Key " + key);
        return key;
    }
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        System.out.println("NKK: Tokenbefore ");
        String tokenGenerated = Jwts.builder()
                .setSubject(userDetails.getUsername())
                .signWith(generateKey())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .compact();

        System.out.println("NKK: Token: " + tokenGenerated);
        return tokenGenerated;
    }

    private SecretKey getKey() {
        if (key == null) {
            generateKey();
        }
        return key;
    }

    public String getUsernameFromToken(String jwtToken) {
        return getClaimFromToken(jwtToken, Claims::getSubject);
    }

    private Date getExpirationFromToken(String jwtToken ) {
        return getClaimFromToken(jwtToken, Claims::getExpiration);
    }

    private boolean isTokenExpired(String jwtToken) {
        final Date expirationDate = getExpirationFromToken(jwtToken);

        return expirationDate.before(new Date());
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }

    public boolean validateToken(String jwtToken, UserDetails userDetails) {
        final String username = getUsernameFromToken(jwtToken);

        if (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken)) {
            return true;
        }
        return  false;
    }
}
