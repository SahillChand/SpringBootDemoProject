package com.example.demo.Service;

import com.example.demo.protos.SignupRequestDTO;
import com.example.demo.protos.SignupRequestEntity;
import com.example.demo.protos.SignupResponseDTO;
import com.example.demo.protos.UpdateBalanceRequestDTO;

public interface CustomerService {

    //To fetch existing customer.
    public SignupRequestEntity fetchCustomer(String username);

    //To add New Customer
    public SignupResponseDTO addCustomer(SignupRequestDTO signupRequestDTO) throws Exception;

    //To delete Customer if it exists
    public int deleteCustomer(String username);

    //To update balance of already existing customer.
    public void updateBalance(UpdateBalanceRequestDTO updateBalanceRequestDTO);
}
