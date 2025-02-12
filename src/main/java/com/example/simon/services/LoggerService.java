package com.example.simon.services;

import org.springframework.stereotype.Service;

@Service
public class LoggerService {
    public void log(String message) {
        System.out.println("LOG: " + message); // Simulating logging
    }
}