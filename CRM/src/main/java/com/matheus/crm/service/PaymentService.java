//package com.matheus.crm.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.matheus.crm.dto.PaymentDTO;
//import com.matheus.crm.entity.Payment;
//import com.matheus.crm.repository.PaymentRepository;
//
//@Service
//public class PaymentService {
//
//	@Autowired
//	private PaymentRepository paymentRepository;
//
//	@Transactional(readOnly = true)
//	public List<PaymentDTO> findAllpayments() {
//		List<Payment> list = paymentRepository.findAll();
//
//		List<PaymentDTO> listDto = list.stream().map(x -> new PaymentDTO(x)).collect(Collectors.toList());
//		return listDto;
//	}
//
//}
