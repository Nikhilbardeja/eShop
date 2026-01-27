package com.example.eShop.Service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.eShop.Entity.AdminEntity;
import com.example.eShop.Repository.AdminRepo;

@Service("adminDetailsServiceImpl")
public class AdminDetailsServiceImpl implements UserDetailsService {
    private final AdminRepo adminRepo;

    public AdminDetailsServiceImpl(AdminRepo adminRepo){
        this.adminRepo = adminRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminEntity entity = adminRepo.findByUserName(username);

        if (entity == null) throw new UsernameNotFoundException("Username not found");
        return new User(entity.getUserName(), entity.getPassword(), List.of(new SimpleGrantedAuthority("ADMIN")));
    }
}
