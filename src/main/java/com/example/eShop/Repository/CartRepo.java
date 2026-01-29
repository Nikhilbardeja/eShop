package com.example.eShop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eShop.Entity.CartEntity;

public interface CartRepo extends JpaRepository<CartEntity, CartEntity.CartId>{
    List<CartEntity> findByUserId(Integer userId);
}
