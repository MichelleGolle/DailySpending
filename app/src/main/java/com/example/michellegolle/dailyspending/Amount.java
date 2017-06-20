package com.example.michellegolle.dailyspending;

import java.text.DateFormat;
import java.util.Date;

public class Amount {
    private int id;
    private String amount;
    private String date;
    private String note;
    private String category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAmount() { return amount; }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //return true if date is this month WIP
//    public boolean isCurrentMonth() {
        //need to decide what format date should come in as in new entry form before using dateformat parser
//    }
}

