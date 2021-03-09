package com.service.Items;

import java.util.Date;

public class Data {
    private final int id;
    private final float price;
    private final Date datePurchase;
    private final int amount;
    private final String userName;
    private final String name;

    public Data(int id, float price, Date datePurchase, int amount, String userName, String name) {
        this.id = id;
        this.price = price;
        this.datePurchase = datePurchase;
        this.amount = amount;
        this.userName = userName;
        this.name = name;
    }

    public Data() {
        this.id = 0;
        this.price = 0;
        this.datePurchase = null;
        this.amount = 0;
        this.userName = "";
        this.name = "";
    }

    public int getId() { return id; }

    public float getPrice() { return price; }

    public int getAmount() { return amount; }

    public Date getDatePurchase() { return datePurchase; }

    public String getUserName() { return userName; }

    public String getName() { return name; }
}
