package com.example.demo.Service;

import com.example.demo.Dao.Customer;
import com.example.demo.Dao.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    //perform validations.
    @Autowired
    private CustomerRepo ctRepo;

    public Customer getCustomer(String username) throws Exception{
        return ctRepo.getCustomer(username);
    }

    public int addCustomer(Customer customer){
        return ctRepo.addCustomer(customer);
    }

    public int deleteCustomer(String username) throws Exception{
        return ctRepo.deleteCustomer(username);
    }

    public int updateBalance(Customer customer) throws Exception{
        return ctRepo.updateBalance(customer);
    }
}
