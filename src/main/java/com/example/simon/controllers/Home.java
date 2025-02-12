package com.example.simon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class Home {

    @GetMapping("/")
    public ResponseEntity<String> getHome(){
        return new ResponseEntity<>("Welcome Home", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<String> getAllUsers(){
        return new ResponseEntity<>("List of users", HttpStatus.OK);
    }

    @GetMapping("/transactions")
    public ResponseEntity<String> getAllTransactions(Authentication auth){
        System.out.println("User name: "+auth.getName());
        System.out.println("User authorities: "+auth.getAuthorities());
        return new ResponseEntity<>("List of transactions", HttpStatus.OK);
    }

}
