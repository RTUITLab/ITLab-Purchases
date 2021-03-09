package com.service.Items;

import javax.persistence.*;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    private Date datePurchase;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "datetimecreate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeCreate;

    @Column(name = "datetimeindb")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeInDB;

    @Column(name = "username")
    private String userName;

    @Column(name = "datetimeinarchive")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTimeInArchive;

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

    public Date getDatePurchase() {
        return datePurchase;
    }

    public void setDatePurchase(Date datePurchase) {
        this.datePurchase = datePurchase;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDateTimeCreate() {
        return dateTimeCreate;
    }

    public void setDateTimeCreate(Date dateTimeCreate) {
        this.dateTimeCreate = dateTimeCreate;
    }

    public Date getDateTimeInDB() {
        return dateTimeInDB;
    }

    public void setDateTimeInDB(Date dateTimeInDB) {
        this.dateTimeInDB = dateTimeInDB;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDateTimeInArchive() {
        return dateTimeInArchive;
    }

    public void setDateTimeInArchive(Date dateTimeInArchive) {
        this.dateTimeInArchive = dateTimeInArchive;
    }

    public void setActToChange(String actToChange) {
        this.actToChange = actToChange;
    }

    public String getActToChange() {
        return actToChange;
    }

}