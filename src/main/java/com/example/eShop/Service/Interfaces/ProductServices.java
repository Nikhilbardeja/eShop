package com.example.eShop.Service.Interfaces;

import com.example.eShop.Model.Product;

public interface ProductServices {
    String create(Product product);
    String update(Integer id, Product product);
    String delete(Integer id);
    Product get(Integer id);
}
