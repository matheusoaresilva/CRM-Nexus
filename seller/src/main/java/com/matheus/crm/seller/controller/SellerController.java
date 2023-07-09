package com.matheus.crm.seller.controller;

import com.matheus.crm.seller.dto.SellerDTO;
import com.matheus.crm.seller.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/sellers")
public class SellerController {


    @Autowired
    private SellerService service;

    @GetMapping()
    public Page<SellerDTO> getAllSellers(@PageableDefault(size = 10) Pageable pageable){
       return service.getAllSellers(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDTO> findById(@PathVariable Long id){
        SellerDTO dto = service.findSellerById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping()
    public ResponseEntity<SellerDTO> createSeller(@RequestBody SellerDTO dto, UriComponentsBuilder builder){
        SellerDTO seller = service.createSeller(dto);

        URI uri = builder.path("/sellers/{id}").buildAndExpand(seller.getId()).toUri();

        return ResponseEntity.created(uri).body(seller);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SellerDTO> updateSeller(@PathVariable Long id, @RequestBody @Valid SellerDTO dto){
        SellerDTO sellerDTO = service.updateSeller(id, dto);

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{id}/disable")
    public String disableUserProfile(@PathVariable Long id){
        service.disableUserProfile(id);

        return "Profile successfully deactivated!";
    }
}
