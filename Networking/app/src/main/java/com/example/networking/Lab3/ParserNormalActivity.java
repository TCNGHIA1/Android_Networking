package com.example.networking.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.networking.R;
import com.example.networking.adapter.ProductAdapter;
import com.example.networking.models.Product;
import com.example.networking.untils.HttpHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserNormalActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parser_normal);
        listView = findViewById(R.id.list_item);
        new GetProductsAsyncTask(ParserNormalActivity.this,listView).execute();
    }
}

class GetProductsAsyncTask extends AsyncTask<Void,Void,Void> {
    ArrayList<Product> arrayList;
    ProgressDialog dialog;
    ListView listView;
    ProductAdapter adapter;
    Context context;
    public static String url = "http://192.168.15.136:3000/products/all";

    public GetProductsAsyncTask(Context context,ListView listView){
        this.context = context;
        this.dialog = new ProgressDialog(context);
        this.listView = listView;
        arrayList = new ArrayList<>();
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Loading...");
        dialog.show();

    }

    @Override
    protected Void doInBackground(Void... voids) {
        HttpHandler handler = new HttpHandler();
        String jsonStr = handler.makeServiceCall(url);
        if(jsonStr!=null){
        try{
//            JSONObject jsonObject = new JSONObject(jsonStr);
            //Getting
            JSONArray products = new JSONArray(jsonStr);
            //looping
            for(int i = 0;i<products.length();i++){
                JSONObject c= products.getJSONObject(i);
                String id = c.getString("id");
                String name = c.getString("name");
                String category = c.getString("category");
                String price = c.getString("price");
                String description = c.getString("description");
                String imageURL = c.getString("imageURL");

                Product product = new Product();
                product.setId(Integer.parseInt(id));
                product.setName(name);
                product.setCategory(category);
                product.setPrice(price);
                product.setDescription(description);
                product.setImageUrl(imageURL);
                arrayList.add(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        }else{
            Log.i("CHECK", "Couldn't get json from server");
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        if(dialog.isShowing()){
            dialog.dismiss();
        }
        adapter= new ProductAdapter(context,arrayList);
        listView.setAdapter(adapter);
    }


}