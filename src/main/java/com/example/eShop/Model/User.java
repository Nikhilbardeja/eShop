package com.example.eShop.Model;


import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails{
    private Integer id;
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;


}