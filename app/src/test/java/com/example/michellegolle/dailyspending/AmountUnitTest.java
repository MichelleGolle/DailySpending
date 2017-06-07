package com.example.michellegolle.dailyspending;

import org.junit.Test;

import static org.junit.Assert.*;


public class AmountUnitTest {
    @Test
    public void getId() throws Exception {
        Amount amount = new Amount();
        amount.setId(12345);
        assertEquals(amount.getId(), 12345);
    }

    @Test
    public void getAmount() throws Exception {
        Amount amount = new Amount();
        amount.setAmount("44.44");
        assertEquals(amount.getAmount(), "44.44");
    }

    @Test
    public void getDate() throws Exception {
        Amount amount = new Amount();
        amount.setDate("1/1/11");
        assertEquals(amount.getDate(), "1/1/11");
    }

    @Test
    public void getNote() throws Exception {
        Amount amount = new Amount();
        amount.setNote("Note");
        assertEquals(amount.getNote(), "Note");
    }

    @Test
    public void getCategory() throws Exception {
        Amount amount = new Amount();
        amount.setCategory("food");
        assertEquals(amount.getCategory(), "food");
    }

}