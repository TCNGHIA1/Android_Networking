package com.example.networking.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {
    @SerializedName("id")
    @Expose
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @SerializedName("name")
    @Expose
    String name;
    @SerializedName("description")
    @Expose
        String description ;
    @SerializedName("imageURL")
    @Expose
    String imageURL ;
    @SerializedName("category")
    @Expose
        String category ;
    @SerializedName("price")
    @Expose
        String price;
    @SerializedName("quantity")
    @Expose
        String quantity;

    public Product(){}

    public Product(int id,String name, String description, String imageUrl, String category, String price, String quantity) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.imageURL = imageUrl;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageURL;
    }

    public void setImageUrl(String imageUrl) {
        this.imageURL = imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
