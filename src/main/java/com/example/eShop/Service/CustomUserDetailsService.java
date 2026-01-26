package com.example.eShop.Service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.eShop.Entity.UserEntity;
import com.example.eShop.Repository.UserSignupRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    private final UserSignupRepo repo;

    public CustomUserDetailsService(UserSignupRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = repo.findByUserName(username);

        if (entity == null) throw new UsernameNotFoundException("Username not found");
        return new User(entity.getUserName(), entity.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
    }
}