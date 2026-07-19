package org.example.ventory.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    // مفتاح سري للتشفير (بيولد مفتاح آمن تلقائياً)
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // صلاحية الـ Token (مثلاً: 24 ساعة بالميلى ثانية)
    private final long jwtExpirationMs = 86400000;

    // 1️⃣ ميثود توليد الـ Token بعد ما الـ Login ينجح
    public String generateToken(Authentication authentication) {
        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // 2️⃣ ميثود قراءة الـ Username من الـ Token (سنحتاجها في الـ Filter لاحقاً)
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // 3️⃣ ميثود التأكد من صحة الـ Token وهل انتهى وقته أم لا
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            // هنا ممكن تمسك إيرورز الـ Expired أو الـ Invalid token لو حابب تlog لها
            return false;
        }
    }
}