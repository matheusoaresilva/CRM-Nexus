package com.matheus.crm.customer.service.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String m){
        super(m);
    }
}
