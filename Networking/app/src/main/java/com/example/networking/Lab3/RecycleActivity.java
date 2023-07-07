package com.example.networking.Lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.networking.DAO.ProductList;
import com.example.networking.R;
import com.example.networking.adapter.RecyclerAdapter;
import com.example.networking.models.Product;
import com.example.networking.untils.ApiService;
import com.example.networking.untils.InternetConnection;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RecycleActivity extends AppCompatActivity {
    FloatingActionButton fab;
    RecyclerView recyclerView;
    List<Product> products;
    RecyclerAdapter adapter;

    String URL = "http:192.168.15.136:3000/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        products = new ArrayList<>();

        fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fab.setOnClickListener(v->{
            if(InternetConnection.checkConnection(getApplicationContext())){
                final ProgressDialog dialog;
                dialog = new ProgressDialog(RecycleActivity.this);
                dialog.setTitle("Loading");
                dialog.setMessage("Waiting...");
                dialog.show();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);

                Call<List<Product>> call = apiService.getAllProducts("");
                call.enqueue(new Callback<List<Product>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                        dialog.dismiss();
                        Log.i("CHECK response", response.toString());
                        if(response.isSuccessful()){
                            // binding adapter
                            products = response.body();
                            adapter = new RecyclerAdapter(products);
                            recyclerView.setAdapter(adapter);
                        }else{
                            Toast.makeText(RecycleActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Product>> call, Throwable t) {
                        dialog.dismiss();
                        Log.i("CHECK call", t.toString());

                    }
                });
            } else{
                Toast.makeText(this, "Internet connection not available", Toast.LENGTH_SHORT).show();
            }
        });
    }
}