package com.example.networking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.networking.Lab1.MainLab1Activity;
import com.example.networking.Lab1.ThreadActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn_lab1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_lab1 = findViewById(R.id.btn_Lab1);
        btn_lab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainLab1Activity.class));
                finish();
            }
        });
    }
}