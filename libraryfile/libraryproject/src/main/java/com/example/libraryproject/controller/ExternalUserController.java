package com.example.libraryproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.libraryproject.service.ExternalUser;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
public class ExternalUserController {
    
    

    private final ExternalUser externalUser;
    public ExternalUserController(ExternalUser externalUser) {
        this.externalUser = externalUser;
    }

    @GetMapping("/data")
    public Object getData(){
        return externalUser.fetchExternalUser();
    }
    
    
}
