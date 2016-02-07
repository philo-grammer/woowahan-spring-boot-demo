package com.woowahan.demo.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sykim on 2016. 2. 7..
 */
public class CustomerTest {

    @Test
    public void testCustomer() {

        Customer customer = new Customer(1L, "보", "물");

        assertEquals(Long.valueOf(1L), customer.getId());
        assertEquals("보", customer.getFirstName());
        assertEquals("물", customer.getLastName());
        
    }
}