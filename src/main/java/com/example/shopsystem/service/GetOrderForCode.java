package com.example.shopsystem.service;

import com.example.shopsystem.model.Order;
import com.example.shopsystem.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Siparişi ID ile getirme
    public Order getOrderForCode(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
}

