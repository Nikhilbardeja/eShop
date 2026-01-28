package com.example.eShop.Controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/user/sinup")
    public String user(@RequestBody User user){
        return signup.userSignup(user);
    }

    @GetMapping("/user/test")
    public String userTest(){
        return "User Working";
    }

    @GetMapping("/user/login")
    public ResponseEntity<String> userLogin(){
        String html = "<html><body><form action='/user/login' method='post'><label for='username'>Username:</label><input type='text' id='username' name='username'><br><br><label for='password'>Password:</label><input type='password' id='password' name='password'><br><br><input type='submit' value='Login'></form></body></html>";
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }

    @GetMapping("/admin/login")
    public ResponseEntity<String> adminLogin(){
        String html = "<html><body><form action='/admin/login' method='post'><label for='username'>Username:</label><input type='text' id='username' name='username'><br><br><label for='password'>Password:</label><input type='password' id='password' name='password'><br><br><input type='submit' value='Login'></form></body></html>";
        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(html);
    }
    
}
