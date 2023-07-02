package com.matheus.crm.product.service.exception;

public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DatabaseException(String m){
        super(m);
    }
}
