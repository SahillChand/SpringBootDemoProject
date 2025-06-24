package com.example.demo.Service.Impl;

import com.example.demo.Dao.AssetDetailsRepo;
import com.example.demo.Dao.AuthoritiesRepo;
import com.example.demo.Dao.CustomerRepo;
import com.example.demo.Service.CustomerService;
import com.example.demo.protos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private AssetDetailsRepo assetDetailsRepo;

    @Autowired
    private AuthoritiesRepo authoritiesRepo;

    @Override
    public SignupRequestEntity fetchCustomer(String username){
        return customerRepo.fetchCustomer(username);
    }

    @Override
    public SignupResponseDTO addCustomer(SignupRequestDTO signupRequestDTO) throws Exception{

        SignupRequestEntity signupRequestEntity1 = customerRepo.fetchCustomer(signupRequestDTO.getUsername());
        if(signupRequestEntity1!=null)
            throw new Exception("You probably trying to add Duplicate Entry");
        SignupRequestEntity signupRequestEntity=SignupRequestEntity
                .newBuilder()
                .setUsername(signupRequestDTO.getUsername())
                .setPassword("{noop}"+signupRequestDTO.getPassword())
                .setBalance(0)
                .build();
        SignupResponseDTO signupResponseDTO = customerRepo.addCustomer(signupRequestEntity);
        assetDetailsRepo.addCustomerToAssetDetails(signupRequestDTO.getUsername());
        authoritiesRepo.addCustomerToAuthorities(signupRequestDTO.getUsername());
        return signupResponseDTO;
    }

    @Override
    public int deleteCustomer(String username){
        return customerRepo.deleteCustomer(username);
    }

    @Override
    public void updateBalance(UpdateBalanceRequestDTO updateBalanceRequestDTO){
        UpdateBalanceRequestEntity updateBalanceRequestEntity=UpdateBalanceRequestEntity.newBuilder().setUsername(updateBalanceRequestDTO.getUsername()).setBalance(updateBalanceRequestDTO.getBalance()).build();
        customerRepo.updateCustomerBalance(updateBalanceRequestEntity);
    }
}
