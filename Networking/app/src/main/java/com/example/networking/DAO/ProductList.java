package com.example.networking.DAO;

import com.example.networking.models.Product;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ProductList {
    @SerializedName("products")
    @Expose
    private List<Product> products;

    public List<Product> getProducts(){
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
