package com.example.demo.controller;

import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/get/{username}")
    public SignupRequestEntity getCustomer(@PathVariable String username){
        return customerService.fetchCustomer(username);
    }

    @PostMapping("/add")
    public SignupResponseDTO addCustomer(@RequestBody SignupRequestDTO signupRequestDTO) throws Exception{

        if(signupRequestDTO.getUsername().isEmpty())
            throw new Exception("Invalid Username");
        else if(signupRequestDTO.getPassword().isEmpty())
            throw new Exception("Invalid Password");

        return customerService.addCustomer(signupRequestDTO);
    }

    @DeleteMapping("/delete/{username}")
    public int deleteCustomer(@PathVariable String username){
        return customerService.deleteCustomer(username);
    }

    @PatchMapping("/updateBalance")
    public void updateBalance(@RequestBody UpdateBalanceRequestDTO updateBalanceRequestDTO) throws Exception{

        if(updateBalanceRequestDTO.getUsername().isEmpty())
            throw new Exception("Invalid Username Input");
        else if(updateBalanceRequestDTO.getBalance()<0)
            throw new Exception("Invalid Balance Input");

        customerService.updateBalance(updateBalanceRequestDTO);
    }
}
