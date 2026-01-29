package com.example.eShop.Service.Interfaces;

import java.util.List;

import com.example.eShop.Model.Cart;

public interface CartServices {
    String add(Cart cart);
    String delete(Cart cart);
    String update(Cart cart);
    List<Cart> get(Integer userId);
}
