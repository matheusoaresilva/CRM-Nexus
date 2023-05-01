package com.matheus.crm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheus.crm.dto.AddressDTO;
import com.matheus.crm.service.AddressService;
import com.matheus.crm.service.exception.NotFoundException;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	@RequestMapping(
			value = "/address/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<AddressDTO> findAddressById(@PathVariable(name = "id") Long id){
		AddressDTO address = addressService.findAddressById(id);
		return ResponseEntity.ok(address);
	}
	
	@RequestMapping(
			value = "/getAddresses", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<AddressDTO>> getAddresses(){
		List<AddressDTO> address =  addressService.findAllAddress();
		if (address.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(address);
		
	}
	
	@RequestMapping(
			value = "/deleteaddress/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<?> deleteById(@PathVariable(name = "id") Long id) {
		try {
			addressService.deleteAddressById(id);
			System.out.println("DELETED");
			return ResponseEntity.noContent().build();
			
		} catch (NotFoundException e) {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@RequestMapping(
			value = "/createaddress",consumes = "application/json" , method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDto) {
		addressDto = addressService.addAddress(addressDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(addressDto.getId()).toUri();
		return ResponseEntity.created(uri).body(addressDto);
	}
	
	@RequestMapping(
			value = "/updateaddress/{id}", consumes = "application/json" , method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<AddressDTO> updateAddress(@PathVariable(name = "id") Long id ,@RequestBody AddressDTO addressDto) {
		addressDto = addressService.updateAddress(id, addressDto);
		
		return ResponseEntity.ok().body(addressDto);
	}
	
	
	
	
	
	
	
	
	
}
