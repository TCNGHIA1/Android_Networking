package com.example.networking.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.networking.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {
    String urlObj ="http://192.168.15.136:3000/products/get/4" ;
    String urlArray ="http://192.168.15.136:3000/products/all";

    private static String TAG = VolleyActivity.class.getSimpleName();
    private ProgressDialog progressDialog;
    private Button btn_make_object,btn_make_array;
    private TextView tv_result;

    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        btn_make_array = findViewById(R.id.btn_make_array);
        btn_make_object = findViewById(R.id.btn_make_object);
        tv_result = findViewById(R.id.tv_results);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);

        btn_make_array.setOnClickListener(v->{
            makeJsonArrayRequest();
        });

        btn_make_object.setOnClickListener(v->{
            makeJsonObjectRequest();
        });
    }

    private void makeJsonArrayRequest() {
        showDialog();

        JsonArrayRequest arrayRequest = new JsonArrayRequest(urlArray, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    jsonResponse = "";
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject object = (JSONObject)response.get(i);

                        String name = object.getString("name");
                        String category = object.getString("category");
                        String price = object.getString("price");

                        jsonResponse += "Name: "+name +"\n\n";
                        jsonResponse += "Category: "+category +"\n\n";
                        jsonResponse += "Price: "+price +"\n\n\n";
                    }
                    tv_result.setText(jsonResponse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                hiddenDialog();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                hiddenDialog();
            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(arrayRequest);
    }

    private void showDialog() {
        if(!progressDialog.isShowing()){
            progressDialog.show();
        }
    }

    private void hiddenDialog(){
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }


    private void makeJsonObjectRequest() {
        showDialog();

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, urlObj, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                jsonResponse ="";
                try{
                    String name = response.getString("name");
                    String category = response.getString("category");
                    String price = response.getString("price");

                    jsonResponse += "Name: "+name +"\n\n";
                    jsonResponse += "Category: "+category +"\n\n";
                    jsonResponse += "Price: "+price +"\n\n";
                tv_result.setText(jsonResponse);
                }
            catch (Exception e){
                    e.printStackTrace();
                }
                hiddenDialog();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                hiddenDialog();
            }
        });
        AppController.getInstance().addToRequestQueue(objectRequest);
    }
}