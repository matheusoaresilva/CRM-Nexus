package com.matheus.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.dto.ShippingCompanyDTO;
import com.matheus.crm.service.ShippingCompanyService;


@Controller
public class ShippingCompanyController {

	@Autowired
	private ShippingCompanyService shippingCompanyService;
	
	@RequestMapping(
			value = "/getshippingcompanys", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<ShippingCompanyDTO>> getshippingCompanys(){
		List<ShippingCompanyDTO> shippingCompanys =  shippingCompanyService.findAllshippingCompanys();
		if (shippingCompanys.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(shippingCompanys);
		
	}
}
