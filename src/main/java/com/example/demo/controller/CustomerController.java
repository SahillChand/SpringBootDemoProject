package com.example.demo.controller;

import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import com.example.demo.protos.SignupRequestDTO;
import com.example.demo.protos.SignupResponseDTO;
import com.example.demo.protos.SignupRequestEntity;
import com.example.demo.protos.UpdateBalanceRequestDTO;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //value refers to name of bucket/cache where the cached data will be stored and key refers to the key of cached data inside bucket named value.
    @GetMapping("/get/{username}")
    @Cacheable(value="userDetails",key="#username")
    public SignupRequestEntity getCustomer(@PathVariable String username){
        System.out.println("Function");
        return customerService.fetchCustomer(username);
    }

    @PostMapping("/add")
    @Cacheable(value="userDetails",key="#signupRequestDTO.username")
    public SignupResponseDTO addCustomer(@RequestBody SignupRequestDTO signupRequestDTO) throws Exception{

        if(signupRequestDTO.getUsername().isEmpty())
            throw new Exception("Invalid Username");
        else if(signupRequestDTO.getPassword().isEmpty())
            throw new Exception("Invalid Password");

        return customerService.addCustomer(signupRequestDTO);
    }

    //Here when we delete a customer we also remove the corresponding cached value from cache.
    @DeleteMapping("/delete/{username}")
    @CacheEvict(value="userDetails",key = "#username")
    public int deleteCustomer(@PathVariable String username){
        return customerService.deleteCustomer(username);
    }


    @PatchMapping("/updateBalance")
    @CacheEvict(value="userDetails",key = "#updateBalanceRequestDTO.username")
    public void updateBalance(@RequestBody UpdateBalanceRequestDTO updateBalanceRequestDTO) throws Exception{

        if(updateBalanceRequestDTO.getUsername().isEmpty())
            throw new Exception("Invalid Username Input");
        else if(updateBalanceRequestDTO.getBalance()<0)
            throw new Exception("Invalid Balance Input");

        customerService.updateBalance(updateBalanceRequestDTO);
    }
}
