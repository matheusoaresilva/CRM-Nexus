package com.matheus.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.dto.SellerDTO;
import com.matheus.crm.service.SellerService;



@Controller
public class SellerController {

	@Autowired
	private SellerService sellerService;
	
	@RequestMapping(
			value = "/getsellers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<SellerDTO>> getsellers(){
		List<SellerDTO> sellers =  sellerService.findAllSellers();
		if (sellers.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(sellers);
	}
}
