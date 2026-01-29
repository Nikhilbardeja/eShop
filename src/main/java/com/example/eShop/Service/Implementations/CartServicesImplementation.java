package com.example.eShop.Service.Implementations;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.eShop.Entity.CartEntity;
import com.example.eShop.Model.Cart;
import com.example.eShop.Repository.CartRepo;
import com.example.eShop.Service.Interfaces.CartServices;

@Service
public class CartServicesImplementation implements CartServices{

    private final CartRepo repo;
    private final ModelMapper modelMapper;

    public CartServicesImplementation(CartRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public String add(Cart cart) {
        repo.save(modelMapper.map(cart, CartEntity.class));
        return "Added to cart";
    }

    @Override
    public String delete(Cart cart) {

        repo.delete(modelMapper.map(cart, CartEntity.class));

        return "Deleted from cart";
    }

    @Override
    public String update(Cart cart) {
        repo.save(modelMapper.map(cart, CartEntity.class));
        return "Cart updated successfully";
    }

    @Override
    public List<Cart> get(Integer userId) {
        List<CartEntity> entities = repo.findByUserId(userId);
        List<Cart> cart = new ArrayList<Cart>();
        
        for (CartEntity entity: entities)
            cart.add(modelMapper.map(entity, Cart.class));
        
        return cart;
    }
}
