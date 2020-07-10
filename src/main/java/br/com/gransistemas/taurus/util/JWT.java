package br.com.gransistemas.taurus.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JWT {
    private static String JWT_PRIVATE_KEY = "123";

	public static String generateToken(Object jwtSubject) {
		long expiration = TimeUnit.DAYS.toMillis(30);

		return Jwts.builder()
			.setSubject(jwtSubject.toString())
			.signWith(SignatureAlgorithm.HS512, TextCodec.BASE64.encode(JWT_PRIVATE_KEY))
			.setExpiration(new Date(System.currentTimeMillis() + expiration))
		.compact();
	}

	public static Claims parseToken(String jwtToken) {
		return Jwts.parser()
			.setSigningKey(TextCodec.BASE64.encode(JWT_PRIVATE_KEY))
			.parseClaimsJws(jwtToken)
		.getBody();
	}
}