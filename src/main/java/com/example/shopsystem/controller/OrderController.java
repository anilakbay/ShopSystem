package com.example.shopsystem.controller;

import com.example.shopsystem.model.Order;
import com.example.shopsystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Sipariş oluşturma
    @PostMapping("/{customerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId, @RequestBody List<Long> productIds) {
        Order order = orderService.placeOrder(customerId, productIds);
        return ResponseEntity.ok(order);
    }

    // Sipariş ID ile getirme
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderForCode(@PathVariable Long orderId) {
        Order order = orderService.getOrderForCode(orderId);
        return ResponseEntity.ok(order);
    }

    // Bir müşterinin tüm siparişlerini getirme
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getAllOrdersForCustomer(@PathVariable Long customerId) {
        List<Order> orders = orderService.getAllOrdersForCustomer(customerId);
        return ResponseEntity.ok(orders);
    }
}

