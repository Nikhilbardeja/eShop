package com.example.eShop.Service.Implementations;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.eShop.Model.Product;
import com.example.eShop.Entity.ProductEntity;
import com.example.eShop.Exception.ProductExceptions.ProductNotFoundException;
import com.example.eShop.Repository.ProductRepo;
import com.example.eShop.Service.Interfaces.ProductServices;

@Service
public class ProductServicesImplementation implements ProductServices {

    
    private final ProductRepo repo;
    private final ModelMapper modelMapper;


    public ProductServicesImplementation(ProductRepo repo, ModelMapper modelMapper){
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    @Override
    public String create(@RequestBody Product product) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(product, entity);
        repo.save(entity);
        return "Product Saved Successfully";
    }

    @Override
    public String update(Integer id, Product product) {
        ProductEntity entity = repo.findById(id).get();
        BeanUtils.copyProperties(product, entity);
        repo.save(entity);
        return "Product Updated Successfully";
    }

    @Override
    public String delete(Integer id) {
        ProductEntity entity = repo.findById(id).get();
        repo.delete(entity);
        return "Product Deleted Successfully";
    }

    @Override
    public Product get(Integer id) {
        ProductEntity entity = repo.findById(id)
                        .orElseThrow(()-> {
                            System.out.println("Throwing ProductNotFoundException");
                            return new ProductNotFoundException("Product Not Found with Id: " + id);
                        });

        
        return modelMapper.map(entity, Product.class);

    }

    
}
