package com.service.Items;

public class CostNameData {
    private long id;
    private String name;
    private String checkName;

    public CostNameData(long id, String name, String checkName) {
        this.id = id;
        this.name = name;
        this.checkName = checkName;
    }

    public CostNameData() {
        this.id = 0;
        this.name = "";
        this.checkName = "";
    }

    public void setId(long id){ this.id = id; }

    public void setName(String name){
        this.name = name;
    }

    public void setСheckName(String checkName){ this.checkName = checkName; }

    public long getId() { return id; }

    public String getName() { return name; }

    public String getСheckName() { return checkName; }
}
