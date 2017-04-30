package com.packt.webstore.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CartTest {

    private Cart cart;
    @Before
    public void setup() {
        cart = new Cart();
    }

    @Test
    public void cart_grand_total_should_be_equal_to_product_unit_price_in_case_of_single_quantity() {
        //Ustaw
        Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
        CartItem cartItem = new CartItem();
        cartItem.setProduct(iphone);
        cart.addCartItem(cartItem);
        //Wykonaj
        BigDecimal grandTotal = cart.getGrandTotal();
        //Porownaj
        Assert.assertEquals(iphone.getUnitPrice(), grandTotal);
    }
}
