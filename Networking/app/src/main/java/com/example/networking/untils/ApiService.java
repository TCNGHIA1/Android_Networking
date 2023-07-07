package com.example.networking.untils;

import com.example.networking.DAO.ProductList;
import com.example.networking.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("products/all")
    Call<List<Product>> getAllProducts(@Query("search") String search);
}
