package com.example.networking.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.networking.R;
import com.example.networking.adapter.ContactAdapter;
import com.example.networking.models.Contact;
import com.example.networking.untils.HttpHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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
    ArrayList<Contact> arrayList;
    ProgressDialog dialog;
    ListView listView;
    ContactAdapter adapter;
    Context context;
    public static String url = "http://192.168.15.136:5000/api/lab3/contacts";

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
            //Getting
            JSONObject jsonArray = new JSONObject(jsonStr);
            JSONArray contacts = jsonArray.getJSONArray("contacts");
            //looping
            for(int i = 0;i<contacts.length();i++){
                JSONObject c= contacts.getJSONObject(i);
                String id = c.getString("id");
                String name = c.getString("name");
                String email = c.getString("email");
                JSONObject phone = c.getJSONObject("phone");

                String mobile = phone.getString("mobile");
                String home = phone.getString("home");
                String office = phone.getString("office");


                Contact contact = new Contact();
                contact.setId(id);
                contact.setName(name);
                contact.setEmail(email);
                contact.setMobile(mobile);
                contact.setOffice(office);
                contact.setHome(home);
                arrayList.add(contact);
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
        adapter= new ContactAdapter(context,arrayList);
        listView.setAdapter(adapter);
    }


}