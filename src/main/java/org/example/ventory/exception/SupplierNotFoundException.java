package org.example.ventory.exception;

public class SupplierNotFoundException extends RuntimeException{
    public SupplierNotFoundException(String message) {
        super(message);
    }
}
