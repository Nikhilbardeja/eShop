package com.example.eShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eShop.Entity.ProductEntity;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    
}
