package com.enyoi.ms_orders.controller;

import com.enyoi.ms_orders.dto.CreateNewOrderNewClientDto;
import com.enyoi.ms_orders.dto.GenerateNewOrderDto;
import com.enyoi.ms_orders.model.Order;
import com.enyoi.ms_orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createNewOrder(@RequestBody GenerateNewOrderDto dto){
        Order order = orderService.createNewOrder(dto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/client")
    public ResponseEntity<Order> createNewOrderNewClient(@RequestBody CreateNewOrderNewClientDto dto){
        Order order = orderService.createNewOrderCreatingNewClient(dto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

}
