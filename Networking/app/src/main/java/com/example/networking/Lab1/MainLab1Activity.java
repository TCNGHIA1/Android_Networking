package com.example.networking.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.networking.MainActivity;
import com.example.networking.R;

public class MainLab1Activity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_thread,btn_asynctask,btn_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab1);

        btn_thread = findViewById(R.id.btn_thread);
        btn_asynctask = findViewById(R.id.btn_async);
        btn_time = findViewById(R.id.btn_time);

        btn_thread.setOnClickListener(this);
        btn_asynctask.setOnClickListener(this);
        btn_time.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if(viewId == R.id.btn_thread){
            startActivity(new Intent(MainLab1Activity.this, ThreadActivity.class));

        }
        if(viewId == R.id.btn_async){
            startActivity(new Intent(MainLab1Activity.this, AsyncActivity.class));

        }
        if(viewId == R.id.btn_time){
            startActivity(new Intent(MainLab1Activity.this, TimeActivity.class));
        }
    }
}