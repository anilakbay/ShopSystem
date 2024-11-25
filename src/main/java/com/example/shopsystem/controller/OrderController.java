package com.example.shopsystem.controller;

import com.example.shopsystem.model.Order; // Order modelini import ediyoruz.
import com.example.shopsystem.service.OrderService; // OrderService'i import ediyoruz.
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    // OrderService'i constructor ile alıyoruz
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Create a new order
    @PostMapping("/{customerId}")
    public ResponseEntity<Order> placeOrder(@PathVariable Long customerId, @RequestBody List<Long> productIds) {
        // orderService.placeOrder metodunu çağırıyoruz ve geri dönen Order'ı ResponseEntity ile dönüyoruz
        return ResponseEntity.ok(orderService.placeOrder(customerId, productIds));
    }

    // Retrieve an order by ID
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
        // orderService.getOrderById metodunu çağırıyoruz ve Order'ı ResponseEntity ile dönüyoruz
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    // Retrieve all orders for a specific customer
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> getOrdersByCustomer(@PathVariable Long customerId) {
        // orderService.getOrdersByCustomer metodunu çağırıyoruz ve listeyi ResponseEntity ile dönüyoruz
        return ResponseEntity.ok(orderService.getOrdersByCustomer(customerId));
    }
}
