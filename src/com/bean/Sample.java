package com.bean;

import java.util.Date;

public class Sample {
    private int id;
    private Date createdAt;
    private String name;

    public Sample() {
    }

    public Sample(int id, Date createdAt, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String uploadedBy) {
        this.name = uploadedBy;
    }
}
