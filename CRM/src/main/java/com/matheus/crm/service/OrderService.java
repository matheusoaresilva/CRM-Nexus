//package com.matheus.crm.service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.matheus.crm.dto.OrderDTO;
//import com.matheus.crm.entity.Order;
//import com.matheus.crm.repository.OrderRepository;
//
//@Service
//public class OrderService {
//
//	@Autowired
//	private OrderRepository orderRepository;
//
//		@Transactional(readOnly = true)
//		public List<OrderDTO> findAllOrders() {
//			List<Order> list = orderRepository.findAll();
//
//			List<OrderDTO> listDto = list.stream()
//					.map(x -> new OrderDTO(x)).collect(Collectors.toList());
//			return listDto;
//		}
//
//}
