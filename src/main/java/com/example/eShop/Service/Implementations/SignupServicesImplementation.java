package com.example.eShop.Service.Implementations;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.eShop.Entity.UserEntity;
import com.example.eShop.Exception.UserExceptions.UsernameAlreadyExistsException;
import com.example.eShop.Model.User;
import com.example.eShop.Repository.UserRepo;
import com.example.eShop.Service.Interfaces.SignupServices;

@Service
public class SignupServicesImplementation implements SignupServices{

    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder encoder;

    public SignupServicesImplementation(UserRepo userRepo, ModelMapper modelMapper, BCryptPasswordEncoder encoder){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
        this.encoder = encoder;
    }

    @Override
    public String userSignup(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        
        if(!userRepo.existsByUserName(user.getUserName())) userRepo.save(modelMapper.map(user, UserEntity.class));
        else throw new UsernameAlreadyExistsException("User with this userName already exists.");
        return "User Created Successfully";
    }

    

}
