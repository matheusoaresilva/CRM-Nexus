package com.matheus.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.dto.PaymentDTO;
import com.matheus.crm.service.PaymentService;

@Controller
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(
			value = "/getpayments", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<PaymentDTO>> getpayments(){
		List<PaymentDTO> payments =  paymentService.findAllpayments();
		if (payments.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(payments);
		
	}
}
