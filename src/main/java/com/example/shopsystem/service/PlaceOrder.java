package com.example.shopsystem.service;

import com.example.shopsystem.model.Order;
import com.example.shopsystem.repository.OrderRepository;
import com.example.shopsystem.model.Cart;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Sipariş oluşturma
    public Order placeOrder(Cart cart) {
        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());
        return orderRepository.save(order);
    }
}

