package com.example.eShop.Service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.eShop.Entity.UserEntity;
import com.example.eShop.Repository.UserRepo;
import com.example.eShop.Model.User;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

    private Integer id;
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    private final UserRepo repo;

    public UserDetailsServiceImpl(UserRepo repo){
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity entity = repo.findByUserName(username);

        if (entity == null) throw new UsernameNotFoundException("Username not found");
        return new User(entity.getId(), entity.getUserName(), entity.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }

    
}