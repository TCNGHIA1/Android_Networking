package com.example.networking.DAO;

import com.example.networking.models.Contact;
import com.example.networking.models.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductList {
    @SerializedName("products")
    @Expose
    private List<Product> contacts;

    public List<Product> getProducts(){
        return contacts;
    }

    public void setProducts(List<Product> contacts) {
        this.contacts = contacts;
    }
}
