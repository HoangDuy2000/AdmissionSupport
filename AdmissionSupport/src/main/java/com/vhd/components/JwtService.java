/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.components;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.text.ParseException;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author PC
 */
@Component
public class JwtService {
    public static final String SECRET__KEY ="11223344124214";
    public static final byte[] SHARED_SECRET_KEY = SECRET__KEY.getBytes();
    public static final int EXPIRE_TIME = 86400000;
    
    public String generateTokenLogin(String username){
        String token = null;
        try{
            JWSSigner signer = new MACSigner(SHARED_SECRET_KEY);
            
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim("username", username);
            builder.expirationTime(new Date(System.currentTimeMillis() + EXPIRE_TIME));
            
            JWTClaimsSet claimsSet = builder.build();
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(signer);
            token = signedJWT.serialize();
        }catch(JOSEException e){
            System.out.println(e.getMessage());
        }
        
        return token;
    }
    
    private JWTClaimsSet getClaimsFromToken(String token){
        JWTClaimsSet claims = null;
        
        try{
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SHARED_SECRET_KEY);
            if(signedJWT.verify(verifier)){
                claims = signedJWT.getJWTClaimsSet();
            }
        }catch(JOSEException | ParseException e){
            System.err.println(e.getMessage());
        }
        
        return claims;
    }
    
    private Date getExpirationDateFormToken(String token){
        JWTClaimsSet claims = getClaimsFromToken(token);
        Date expiration = claims.getExpirationTime();
        return expiration;
    }
    
    public String getUsernameFormToken(String token){
        String username = null;
        try{
            JWTClaimsSet claims = getClaimsFromToken(token);
            username = claims.getStringClaim("username");
        }catch(ParseException e){
            System.err.println(e.getMessage());
        }
        
        return username;
    }
    
    private Boolean isTokenExpired(String token){
        Date expiration = getExpirationDateFormToken(token);
        return expiration.before(new Date());
        
    }
    
    public Boolean validateTokenLogin(String token){
        if(token == null || token.trim().length() == 0) {
            return false;
        }
        String username = getUsernameFormToken(token);

        return !(username == null || username.isEmpty() || isTokenExpired(token));
    }
}
