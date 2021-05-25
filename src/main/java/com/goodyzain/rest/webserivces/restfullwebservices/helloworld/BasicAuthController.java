package com.goodyzain.rest.webserivces.restfullwebservices.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BasicAuthController {

    @GetMapping(path="/basicAuth")
    private AuthenticationBean  getHelloMessage(){
        return new AuthenticationBean("You are authenticated");
    }
}
