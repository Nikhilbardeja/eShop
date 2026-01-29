package com.example.eShop.Controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eShop.Model.Cart;
import com.example.eShop.Model.User;
import com.example.eShop.Service.Interfaces.CartServices;

@RestController
@RequestMapping("/user/cart")
public class CartController {
    private final CartServices services;

    public CartController(CartServices services){
        this.services = services;
    }

    
    @PostMapping("/add")
    public String add(@RequestBody Cart cart){
        return services.add(cart);
    }

    @PutMapping("/update")
    public String update(@RequestBody Cart cart){
        return services.update(cart);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Cart cart){
        return services.delete(cart);
    }

    @GetMapping("/get")
    public List<Cart> get(@AuthenticationPrincipal User user){
        return services.get(user.getId());
    }
}
