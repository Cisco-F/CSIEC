package com.example.csiec.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
    private static String signkey = "CSIEC";
    private static long expire = 1000 * 60 * 60 * 24; //过期时间为一天

    //生成jwt
    public static String generateJwt(Map<String, Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signkey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
    }

    //解析
    public static Claims parseJwt(String jwt){
        return Jwts.parser()
                .setSigningKey(signkey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
