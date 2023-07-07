package com.example.networking.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.networking.R;

public class MainLab3Activity extends AppCompatActivity {
    Button btn_parser_normal,btn_parser_volley,btn_parser_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3);
        btn_parser_normal = findViewById(R.id.parser_normal);
        btn_parser_volley = findViewById(R.id.parser_volley);

        btn_parser_normal.setOnClickListener(v->{
            startActivity(new Intent(MainLab3Activity.this, ParserNormalActivity.class));
        });
        btn_parser_volley.setOnClickListener(v->{
            startActivity(new Intent(MainLab3Activity.this, VolleyActivity.class));
        });
        btn_parser_image = findViewById(R.id.parser_image);
        btn_parser_image.setOnClickListener(v->{
            startActivity(new Intent(MainLab3Activity.this,RecycleActivity.class));
        });
    }
}