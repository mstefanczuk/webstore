package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    private Map<String, Customer> listOfCustomers = new HashMap<String, Customer>();

    public void saveCustomer(Customer customer) {
        listOfCustomers.put(customer.getCustomerId(), customer);
    }

    public Customer getCustomer(String customerId) {
        return listOfCustomers.get(customerId);
    }

    public boolean isCustomerExist(String customerId) {
        return listOfCustomers.containsKey(customerId);
    }
}
