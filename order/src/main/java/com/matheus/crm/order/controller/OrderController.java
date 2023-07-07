package com.matheus.crm.order.controller;

import com.matheus.crm.order.dto.OrderDTO;
import com.matheus.crm.order.dto.StatusDTO;
import com.matheus.crm.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService service;

//    @GetMapping()
//    public ResponseEntity<List<OrderDTO>> getOrders(){
//        List<OrderDTO> orders =  service.findAllOrders();
//        if (orders.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.ok().body(orders);
//    }

    @PostMapping()
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody @Valid OrderDTO dto, UriComponentsBuilder builder){
        OrderDTO order = service.createOrder(dto);

        URI uri = builder.path("/orders/{id}").buildAndExpand(order.getId()).toUri();

        return ResponseEntity.created(uri).body(order);
    }

//    @PutMapping("/{id}/status")
//    public ResponseEntity<OrderDTO> updateStatus(@PathVariable Long id, @RequestBody StatusDTO statusDTO){
//        OrderDTO dto = service.updateStatus(id, statusDTO);
//
//        return ResponseEntity.ok(dto);
//    }


    @PutMapping("/{id}/paid")
    public ResponseEntity<Void> approvePayment(@PathVariable @NotNull Long id){
        service.updatePayment(id);

        return ResponseEntity.ok().build();
    }

}
