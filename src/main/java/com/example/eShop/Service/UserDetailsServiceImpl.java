package com.example.eShop.Service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.eShop.Entity.UserEntity;
import com.example.eShop.Repository.UserRepo;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserRepo repo;

    public UserDetailsServiceImpl(UserRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = repo.findByUserName(username);

        if (entity == null) throw new UsernameNotFoundException("Username not found");
        return new User(entity.getUserName(), entity.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}