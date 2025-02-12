package com.example.simon.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String welcomeUser(String name){
        return "Welcome "+name+" !";
    }

    public String byUser(String name){
        return "By "+name+" !";
    }

}
