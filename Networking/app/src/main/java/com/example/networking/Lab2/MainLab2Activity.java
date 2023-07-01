package com.example.networking.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.networking.R;

public class MainLab2Activity extends AppCompatActivity {
    Button btn_get_post,btn_math;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab2);
        btn_math = findViewById(R.id.btn_math);
        btn_get_post = findViewById(R.id.btn_get_post);

        btn_get_post.setOnClickListener(v->{
            startActivity(new Intent(this, GetPostActivity.class));
        });
        btn_math.setOnClickListener(v->{
            startActivity(new Intent(this, MathActivity.class));
        });
    }


}