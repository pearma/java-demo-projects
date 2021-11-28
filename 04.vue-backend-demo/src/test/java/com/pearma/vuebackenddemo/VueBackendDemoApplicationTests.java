package com.pearma.vuebackenddemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.stream.IntStream;

import javax.crypto.SecretKey;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@SpringBootTest
class VueBackendDemoApplicationTests {

	@Test
	void mapTest() {
		final AtomicInteger count = new AtomicInteger(5);

		int [] list = {1,2,3};

		IntStream stream=Arrays.stream(list);
		System.out.println("-------------------------------------------");
		stream.map(i->{
			Integer result=count.incrementAndGet();
			System.out.println("result is "+result);
			return result;
		}).sum();
		System.out.println("-------------------------------------------");
	}

	@Test
	void keyTest() {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256); //or HS384 or HS512
		String secretString = Encoders.BASE64.encode(key.getEncoded());		
		assertEquals("abc",secretString);
	}

}
