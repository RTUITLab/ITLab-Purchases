package com.service.Items;

public class ReceivingData {

    private final String name;
    private final float price;
    private final int amount;
    private final String datePurchase;
    private final String dateTimeCreate;
    private final String userName;


    public ReceivingData(String name, float price, String datePurchase, int amount, String dateTimeCreate, String userName) {
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
        this.datePurchase = "";
        this.amount = 0;
        this.dateTimeCreate = "";
        this.userName = "";
    }

    public String getName() { return name; }

    public float getPrice() { return price; }

    public int getAmount() { return amount; }

    public String getDatePurchase() { return datePurchase;  }

    public String getDateTimeCreate() { return dateTimeCreate; }

    public String getUserName() { return userName; }
}
