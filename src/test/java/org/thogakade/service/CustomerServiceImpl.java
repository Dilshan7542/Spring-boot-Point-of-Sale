package org.thogakade.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thogakade.dto.CustomerDTO;

@SpringBootTest
public class CustomerServiceImpl {
    @Autowired
    CustomerService customerService;
    @Test
    public void saveCustomer(){
        customerService.saveCustomer(new CustomerDTO());

    }
}
