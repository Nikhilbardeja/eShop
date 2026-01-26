package com.example.eShop.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eShop.Model.Product;
import com.example.eShop.Service.Interfaces.ProductServices;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServices productServices;

    public ProductController(ProductServices productServices){
        this.productServices = productServices; // constructor dependency injection
    }

    @PostMapping("/create")
    public String create(@RequestBody Product product){
        return productServices.create(product);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Integer id, @RequestBody Product product){
        return productServices.update(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, @RequestBody Product product){
        return productServices.delete(id);
    }

    @GetMapping("/product/{id}")
    public Product get(@PathVariable Integer id){
        return productServices.get(id);
    }
}
