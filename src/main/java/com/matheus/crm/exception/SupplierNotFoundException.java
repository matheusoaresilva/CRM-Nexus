package com.matheus.crm.exception;

public class SupplierNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SupplierNotFoundException(String message) {
		super(message);
	}
}
