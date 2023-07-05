package com.example.networking.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networking.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MathActivity extends AppCompatActivity {
    Button btn_volume,btn_quadratic;
    TextView tv_volume_result,tv_quadratic_result;
    EditText ed_edge,ed_a,ed_b,ed_c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math);
        btn_volume = findViewById(R.id.btn_edge);
        btn_quadratic = findViewById(R.id.btn_quadratic);
        tv_quadratic_result = findViewById(R.id.tv_quadratic_result);
        tv_volume_result = findViewById(R.id.tv_volume_result);
        ed_edge = findViewById(R.id.ed_edge);
        ed_a = findViewById(R.id.ed_a);
        ed_b = findViewById(R.id.ed_b);
        ed_c = findViewById(R.id.ed_c);

        btn_volume.setOnClickListener(v->{
            String edge = ed_edge.getText().toString();
            if(TextUtils.isEmpty(edge)){
                tv_volume_result.setText("Vui lòng nhập dữ liệu để tính toán");
            }else{
                new VolumeAsyncTask(this,tv_volume_result).execute(edge);
            }
        });
        btn_quadratic.setOnClickListener(v->{
            String a = ed_a.getText().toString();
            String b = ed_b.getText().toString();
            String c = ed_c.getText().toString();
            if(TextUtils.isEmpty(a)||TextUtils.isEmpty(c)||TextUtils.isEmpty(b)){
                tv_quadratic_result.setText("Vui lòng nhập dữ liệu để tính toán");
            }else{
                new QuadraticAsyncTask(this,tv_quadratic_result).execute(a,b,c);
            }
        });
    }
}

class VolumeAsyncTask extends AsyncTask<String,Void,String>{
    TextView tv_result;
    ProgressDialog dialog;
    String urlStr = "http://192.168.15.136:3000/api/lab2/cube/volume";
    public VolumeAsyncTask(Context context,TextView tv_result){
        dialog = new ProgressDialog(context);
        this.tv_result = tv_result;
    }
    @Override
    protected String doInBackground(String... strings) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            //param
            String param = "edge="+strings[0];
            byte[] postByte = param.getBytes(StandardCharsets.UTF_8);
            connection.getOutputStream().write(postByte);

            //nhận dữ liệu
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line= reader.readLine())!=null){
                builder.append(line);
            }

            reader.close();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Calculating....");
        dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s!=null){
            dialog.dismiss();
            tv_result.setText(s);
        }
    }
}

class QuadraticAsyncTask extends AsyncTask<String,Void,String>{
    TextView tv_result;
    ProgressDialog dialog;
    String urlStr = "http://192.168.15.136:3000/api/lab2/quadratic";
    public QuadraticAsyncTask(Context context,TextView tv_result){
        dialog = new ProgressDialog(context);
        this.tv_result = tv_result;
    }
    @Override
    protected String doInBackground(String... strings) {
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            //param
            String param = "a="+strings[0]+"&b="+strings[1]+"&c="+strings[2];
            byte[] postByte = param.getBytes(StandardCharsets.UTF_8);
            connection.getOutputStream().write(postByte);

            //nhận dữ liệu
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line= reader.readLine())!=null){
                builder.append(line);
            }

            reader.close();
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Calculating....");
        dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s!=null){
            dialog.dismiss();
            tv_result.setText(s);
        }
    }
}