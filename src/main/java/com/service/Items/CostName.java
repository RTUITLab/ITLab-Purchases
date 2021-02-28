package com.service.Items;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "costname")
public class CostName {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column (name="name")
    private String name;

    @Column (name="checkname")
    private String checkName;

    @OneToMany(mappedBy="idCname",cascade = CascadeType.REFRESH)
    private Set<Expenses> expensesSet;

    public CostName()
    {
        super();
    }

    public Set<Expenses> getExpenses()
    {
        return expensesSet;
    }

    public void setExpenses(Set<Expenses> expensesSet)
    {
        this.expensesSet = expensesSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

}
