package com.example.libraryproject.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service 
public class ExternalUser {

    private final RestTemplate restTemplate=new  RestTemplate();
    
    public Object fetchExternalUser(){
    String url = "https://jsonplaceholder.typicode.com/users";
    return restTemplate.getForObject(url, Object.class);
    }
    
}
