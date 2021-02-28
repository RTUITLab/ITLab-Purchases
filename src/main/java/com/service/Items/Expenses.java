package com.service.Items;

import javax.persistence.*;

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
    private String datePurchase;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "datetimecreate")
    private String dateTimeCreate;

    @Column(name = "datetimeindb")
    private String dateTimeInDB;

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

}
