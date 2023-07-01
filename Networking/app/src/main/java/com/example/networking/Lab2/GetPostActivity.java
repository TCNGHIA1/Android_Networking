package com.example.networking.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networking.R;

public class GetPostActivity extends AppCompatActivity {
    Button btn_get,btn_post;
    TextView tv_get_result,tv_post_result;
    EditText ed_get_w,ed_get_h,ed_post_w,ed_post_h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_post);
        btn_get = findViewById(R.id.btn_get);
        btn_post = findViewById(R.id.btn_post);
        tv_get_result = findViewById(R.id.tv_get_result);
        tv_post_result = findViewById(R.id.tv_post_result);
        ed_get_w = findViewById(R.id.ed_get_w);
        ed_get_h = findViewById(R.id.ed_get_h);
        ed_post_w = findViewById(R.id.ed_post_w);
        ed_post_h = findViewById(R.id.ed_post_h);

        btn_get.setOnClickListener(v->{
            clickGetData(v);
        });
        btn_get.setOnClickListener(v->{
            clickPostData(v);
        });
    }

    private void clickPostData(View v) {
    }
    private void clickGetData(View v) {
    }
}

class GetDataAsyncTask extends AsyncTask<Void,Void,Void>{
    TextView tvResult;
    String widthStr,heightStr;
    Context context;

    public GetDataAsyncTask(Context context, String widthStr, String heightStr, TextView tvResult){
        this.context = context;
        this.widthStr = widthStr;
        this.heightStr = heightStr;
        this.tvResult = tvResult;
    }
    @Override
    protected Void doInBackground(Void... voids) {

        try {

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
    }
}