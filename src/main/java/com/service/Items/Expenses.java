package com.service.Items;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "idcname")
//    private Integer idCname;

    public Expenses()
    {
        super();
    }

    @ManyToOne(cascade= CascadeType.REFRESH)
    @JoinColumn(name = "idcname")
    private CostName idCname;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CostName getIdCname() {
        return idCname;
    }

    public void setIdCname(CostName idCname) {
        this.idCname = idCname;
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

}
