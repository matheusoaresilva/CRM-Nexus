package com.matheus.crm.order.controller;

import com.matheus.crm.order.dto.OrderDTO;
import com.matheus.crm.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getOrders(){
        List<OrderDTO> orders =  service.findAllOrders();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(orders);
    }

}
