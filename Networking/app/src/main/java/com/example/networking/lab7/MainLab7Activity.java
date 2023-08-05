package com.example.networking.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.networking.R;

public class MainLab7Activity extends AppCompatActivity {
    Button btn_Client,btn_ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab7);
        btn_Client = findViewById(R.id.socket_client);
        btn_ip = findViewById(R.id.socket_ip);

        btn_Client.setOnClickListener(v->{
            startActivity(new Intent(this,SockerSeverActivity.class));
        });
        btn_ip.setOnClickListener(v->{
            startActivity(new Intent(this,SocketIPActivity .class));
        });
    }
}