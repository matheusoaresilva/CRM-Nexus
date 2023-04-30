package com.matheus.crm.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.matheus.crm.entity.Address;
import com.matheus.crm.service.AddressService;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@RequestMapping(
			value = "/address/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Optional<Address>> findAddressById(@PathVariable(name = "id") Long id){
		Optional<Address> address = addressService.findAddressById(id);
		if (address == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(address);
	}
}
