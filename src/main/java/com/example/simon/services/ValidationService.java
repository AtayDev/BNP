package com.example.simon.services;


import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    public boolean isValidInput(long a, long b) {
        return a > 0 && b > 0;
    }
}