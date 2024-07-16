package com.emrekirman.glaceon.user.passwordEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderTests {

    @Test
    void encodeTest() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println("encode : "+passwordEncoder.encode("123456"));
    }
}
