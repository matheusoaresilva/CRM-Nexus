package com.matheus.crm.payment.controller;

import com.matheus.crm.payment.dto.PaymentDTO;
import com.matheus.crm.payment.service.PaymentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @GetMapping
    public Page<PaymentDTO> all(@PageableDefault(size = 10)Pageable pageable){
        return service.getAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable @NotNull Long id){
        PaymentDTO dto = service.findById(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> create(@RequestBody @Valid PaymentDTO dto, UriComponentsBuilder builder){
        PaymentDTO payment = service.createPayment(dto);
        URI uri = builder.path("/payments/{id}").buildAndExpand(payment.getId()).toUri();

        return ResponseEntity.created(uri).body(payment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentDTO> update(@PathVariable @NotNull Long id, @RequestBody @Valid PaymentDTO dto){
        PaymentDTO payment = service.updatePayment(id, dto);
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentDTO> delete(@PathVariable @NotNull Long id){
        service.deletePayment(id);

        return ResponseEntity.noContent().build();
    }

//    @PatchMapping("/{id}/confirm")
////    @CircuitBreaker(name = "updateOrder", fallbackMethod = "paymentAuthorizedWithIntegrationPending")
//    public void confirmPayment(@PathVariable @NotNull Long id){
//        service.confirmPayment(id);
//    }

    public void paymentAuthorizedWithIntegrationPending(Long id, Exception e){
        service.changeStatus(id);
    }
}
