package com.packt.webstore.exception;

public class InvalidCartException extends RuntimeException {

    private String cartId;

    public InvalidCartException(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() {
        return cartId;
    }
}
