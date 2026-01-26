package com.example.eShop.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eShop.Model.User;
import com.example.eShop.Service.Interfaces.SignupServices;

@RestController
@RequestMapping("/signup")
public class SignUPController {

    private final SignupServices signup;
    
    public SignUPController(SignupServices signup){
        this.signup = signup;
    }

    @PostMapping("/user")
    public String user(@RequestBody User user){
        return signup.userSignup(user);
    }
    
}
