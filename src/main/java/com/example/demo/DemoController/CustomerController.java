package com.example.demo.DemoController;

import com.example.demo.Dao.Customer;
import com.example.demo.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.protos.CustomerProto;
import com.example.demo.protos.AssetPricesProto;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService ctService;

    @GetMapping("/get/{username}")
    public Customer getCustomer(@PathVariable String username) throws Exception{
        CustomerProto temp=CustomerProto.newBuilder().setUsername("").setPassword("").setBalance(0).build();
        System.out.println(temp);
        return ctService.getCustomer(username);
    }

    @PostMapping("/add")
    public int addCustomer(@RequestBody Customer customer){
        return ctService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{username}")
    public int deleteCustomer(@PathVariable String username)  throws Exception{
        return ctService.deleteCustomer(username);
    }

    @PatchMapping("/updateBalance")
    public int updateBalance(@RequestBody Customer customer) throws Exception{
        if(customer.getUsername()==null)
            throw new Exception();
        return ctService.updateBalance(customer);
    }
}
