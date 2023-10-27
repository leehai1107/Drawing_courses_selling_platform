package com.main.drawingcourse.jwt;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.payload.LoginResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtility {
	 public static final String SECRETKEY = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
	 public static final long JWT_TOKEN_VALIDITY = 1000*60*3;//3m


	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts
	                .parserBuilder()
	                .setSigningKey(getSignKey())
	                .build()
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }


	    public String generateToken(LoginResponse loginResponse){
	        Map<String,Object> claims=new HashMap<>();
	        claims.put("username", loginResponse.getUsername());
	        claims.put("rolename", loginResponse.getRolename());
	        claims.put("fullname", loginResponse.getFullname());
	        claims.put("userid", loginResponse.getUserid());
	        claims.put("dob", loginResponse.getDob().toString());
	        claims.put("description", loginResponse.getDescription());
	        claims.put("phone", loginResponse.getPhone());
	        claims.put("avatar", loginResponse.getAvatar());
	        claims.put("sex", loginResponse.getSex());
	        return createToken(claims);
	    }

	    private String createToken(Map<String, Object> claims) {
	        return Jwts.builder()
	                .setClaims(claims)
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis()+JWT_TOKEN_VALIDITY))
	                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	    }

	    private Key getSignKey() {
	        byte[] keyBytes= Decoders.BASE64.decode(SECRETKEY);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }
}
