package com.example.smartpovar.entity;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("categoryId")
    private int id;
    @SerializedName("categoryName")
    private String categoryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
