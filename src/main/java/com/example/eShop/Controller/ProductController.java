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
@RequestMapping("/admin/product") // it makes it only accessible to admin role
public class ProductController {

    private final ProductServices productServices;


    public ProductController(ProductServices productServices){
        this.productServices = productServices; // constructor dependency injection
    }
    
    @GetMapping("/test")
    public String test(){
        return "Admin Working";
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

    @GetMapping("/get/{id}")
    public Product get(@PathVariable Integer id){
        return productServices.get(id);
    }
}
