package com.example.eShop.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.eShop.Model.User;
import com.example.eShop.Service.Interfaces.SignupServices;

@RestController
public class AuthController {

    private final SignupServices signup;
    
    public AuthController(SignupServices signup){
        this.signup = signup;
    }

    @PostMapping("/user")
    public String user(@RequestBody User user){
        return signup.userSignup(user);
    }

    @GetMapping("/user/login")
    public String userLogin(){
        return "user-login";
    }

    @GetMapping("/admin/login")
    public String adminLogin(){
        return "admin-login";
    }
    
}
