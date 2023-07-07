package com.matheus.crm.payment.service;

import com.matheus.crm.payment.dto.PaymentDTO;
import com.matheus.crm.payment.entity.Payment;
import com.matheus.crm.payment.entity.enums.Status;
//import com.matheus.crm.payment.http.OrderClient;
import com.matheus.crm.payment.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

//    @Autowired
//    private OrderClient order;

    public Page<PaymentDTO> getAll(Pageable pageable){
        return repository
                .findAll(pageable)
                .map(p -> modelMapper.map(p, PaymentDTO.class));
    }

    public PaymentDTO findById(Long id){
        Payment payment = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException());

        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO createPayment(PaymentDTO dto){
        Payment payment = modelMapper.map(dto, Payment.class);
        payment.setStatus(Status.CREATED);
        repository.save(payment);

        return modelMapper.map(payment, PaymentDTO.class);
    }

    public PaymentDTO updatePayment(Long id, PaymentDTO dto) {
        Payment payment = modelMapper.map(dto, Payment.class);

        payment.setId(id);
        payment = repository.save(payment);

        return modelMapper.map(payment, PaymentDTO.class);
    }

    public void deletePayment(Long id){
         repository.deleteById(id);
    }

//    public void confirmPayment(Long id){
//        Optional<Payment> payment = repository.findById(id);
//
//        if (!payment.isPresent()){
//            throw new EntityNotFoundException();
//        }
//        payment.get().setStatus(Status.CONFIRMED);
//        repository.save(payment.get());
//        order.updatePayment(payment.get().getOrderId());
//    }

    public void changeStatus(Long id){
        Optional<Payment> payment = repository.findById(id);

        if (!payment.isPresent()){
            throw new EntityNotFoundException();
        }

        payment.get().setStatus(Status.CONFIRMED_WITHOUT_INTEGRATION);
        repository.save(payment.get());
    }
}
