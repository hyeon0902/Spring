package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class PasswordEncodeTest {

	@Test
	public void 암호화() {
		// Create an encoder with strength 16
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
		String result = encoder.encode("1111");
		System.out.println(result + "비밀번호 암호화");
		assertTrue(encoder.matches("1111", result));
	}
}
