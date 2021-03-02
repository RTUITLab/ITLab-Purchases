package com.service.Items;

import java.util.Date;

public class ReceivingData {

    private final String name;
    private final float price;
    private final int amount;
    private final Date datePurchase;
    private final Date dateTimeCreate;
    private final String userName;


    public ReceivingData(String name, float price, Date datePurchase, int amount, Date dateTimeCreate, String userName) {
        this.name = name;
        this.price = price;
        this.datePurchase = datePurchase;
        this.amount = amount;
        this.dateTimeCreate = dateTimeCreate;
        this.userName = userName;
    }

    public ReceivingData() {
        this.name = "";
        this.price = 0;
        this.datePurchase = null;
        this.amount = 0;
        this.dateTimeCreate = null;
        this.userName = "";
    }

    public String getName() { return name; }

    public float getPrice() { return price; }

    public int getAmount() { return amount; }

    public Date getDatePurchase() { return datePurchase;  }

    public Date getDateTimeCreate() { return dateTimeCreate; }

    public String getUserName() { return userName; }
}
