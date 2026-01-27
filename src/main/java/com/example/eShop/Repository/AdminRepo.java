package com.example.eShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eShop.Entity.AdminEntity;

public interface AdminRepo extends JpaRepository<AdminEntity, Integer>{
    AdminEntity findByUserName(String userName);   
}
