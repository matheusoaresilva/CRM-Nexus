//package com.matheus.crm.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.matheus.crm.dto.SaleDTO;
//import com.matheus.crm.service.SaleService;
//
//
//@Controller
//public class SaleController {
//
//	@Autowired
//	private SaleService saleService;
//
//	@RequestMapping(
//			value = "/getsales", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseEntity<List<SaleDTO>> getsales(){
//		List<SaleDTO> sales =  saleService.findAllSales();
//		if (sales.isEmpty()) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.ok().body(sales);
//
//	}
//}
