package com.packt.webstore.domain.repository;

import com.packt.webstore.domain.Order;
import org.springframework.stereotype.Repository;


public interface OrderRepository {

    Long saveOrder(Order order);
}
