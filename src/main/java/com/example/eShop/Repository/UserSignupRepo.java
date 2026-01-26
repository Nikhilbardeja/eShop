package com.example.eShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eShop.Entity.UserEntity;

public interface UserSignupRepo extends JpaRepository<UserEntity, Integer>{
    UserEntity findByUserName(String userName);
    Boolean existsByUserName(String userName);
} 
