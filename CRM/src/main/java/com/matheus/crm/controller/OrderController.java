package com.matheus.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.dto.OrderDTO;
import com.matheus.crm.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(
			value = "/getorders", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<OrderDTO>> getOrders(){
		List<OrderDTO> orders =  orderService.findAllOrders();
		if (orders.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(orders);
		
	}
}
