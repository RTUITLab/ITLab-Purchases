package com.service.Items;

public class Data {
    private final int id;
    private final float price;
    private final String datePurchase;
    private final int amount;
    private final String userName;

    public Data(int id, float price, String datePurchase, int amount, String userName) {
        this.id = id;
        this.price = price;
        this.datePurchase = datePurchase;
        this.amount = amount;
        this.userName = userName;
    }

    public Data() {
        this.id = 0;
        this.price = 0;
        this.datePurchase = "";
        this.amount = 0;
        this.userName = "";
    }

    public int getId() { return id; }

    public float getPrice() { return price; }

    public int getAmount() { return amount; }

    public String getDatePurchase() { return datePurchase; }

    public String getUserName() { return userName; }
}
