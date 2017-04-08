package com.packt.webstore.service.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import com.packt.webstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.saveCustomer(customer);
    }

    public Customer getCustomer(String customerId) {
        return customerRepository.getCustomer(customerId);
    }

    public boolean isCustomerExist(String customerId) {
        return customerRepository.isCustomerExist(customerId);
    }
}
