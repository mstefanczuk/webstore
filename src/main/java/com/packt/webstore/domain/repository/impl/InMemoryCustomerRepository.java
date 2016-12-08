package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {
        Customer stefan = new Customer("C1", "Michał Stefańczuk", "Warszawa");
        Customer nacior = new Customer("C2", "Mateusz Nieścior", "Józefów");
        Customer krzepki = new Customer("C3", "Michał Krzepiłko", "Bortatycze");

        listOfCustomers.add(stefan);
        listOfCustomers.add(nacior);
        listOfCustomers.add(krzepki);
    }

    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }
}
