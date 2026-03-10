package com.example.Lap05;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenPassword {

    public static void main(String[] args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String password = encoder.encode("123456");

        System.out.println(password);
    }
}