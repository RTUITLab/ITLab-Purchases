package com.service.Items;

import javax.persistence.*;

@Entity
@Table(name = "archive")
public class ArchiveDB {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "idexpenses")
    private Integer idExpenses;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "datepurchase")
    private String datePurchase;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "datetimecreate")
    private String dateTimeCreate;

    @Column(name = "datetimeindb")
    private String dateTimeInDB;

    @Column(name = "username")
    private String userName;

    @Column(name = "datetimeinarchive")
    private String dateTimeInArchive;

    @Column(name = "acttochange")
    private String actToChange;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(Integer idExpenses) {
        this.idExpenses = idExpenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(String datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(String dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public String getDateTimeInDB() {
        return dateTimeInDB;
    }

    public void setDateTimeInDB(String dateTimeInDB) {
        this.dateTimeInDB = dateTimeInDB;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateTimeInArchive() {
        return dateTimeInArchive;
    }

    public void setDateTimeInArchive(String dateTimeInArchive) {
        this.dateTimeInArchive = dateTimeInArchive;
    }

    public void setActToChange(String actToChange) {
        this.actToChange = actToChange;
    }

    public String getActToChange() {
        return actToChange;
    }

}