package com.service.Items;

import java.util.Date;
import java.util.List;

public class DataGet {
    private final int id;
    private final String name;
    private final float price;
    private final Date datePurchase;
    private final int amount;
    private final Date dateTimeCreate;
    private final Date dateTimeInDB;
    private final String userName;

    public DataGet(int id, String name, float price, Date datePurchase, int amount, Date dateTimeCreate, Date dateTimeInDB, String userName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.datePurchase = datePurchase;
        this.amount = amount;
        this.dateTimeCreate = dateTimeCreate;
        this.dateTimeInDB = dateTimeInDB;
        this.userName = userName;
    }

    public DataGet() {
        this.id = 0;
        this.name = "";
        this.price = 0;
        this.datePurchase = null;
        this.amount = 0;
        this.dateTimeCreate = null;
        this.dateTimeInDB = null;
        this.userName = "";
    }

    public int getId() {return id; }

    public String getName() { return name; }

    public float getPrice() { return price; }

    public int getAmount() { return amount; }

    public Date getDatePurchase() { return datePurchase;  }

    public Date getDateTimeCreate() { return dateTimeCreate; }

    public Date getDateTimeInDB() { return dateTimeInDB; }

    public String getUserName() { return userName; }

}
