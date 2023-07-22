package com.example.networking.Lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networking.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class GetPostActivity extends AppCompatActivity{
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


        btn_post.setOnClickListener(v->{
            String width =ed_post_w.getText().toString();
            String height =ed_post_h.getText().toString();
            new PostDataAsyncTask(GetPostActivity.this,tv_post_result).execute(width,height);
        });
        btn_get.setOnClickListener(v->{
            String width =ed_get_w.getText().toString();
            String height =ed_get_h.getText().toString();
            new GetDataAsyncTask(GetPostActivity.this,tv_get_result).execute(width,height);


        });
    }
}

    class GetDataAsyncTask extends AsyncTask<String,Void,String>{
        String urlStr = "http://192.168.15.136:5000/api/lab2/rectangle/get";

        TextView tvResult;
    ProgressDialog dialog;

    public GetDataAsyncTask(Context context, TextView tvResult){
        dialog = new ProgressDialog(context);
        this.tvResult = tvResult;
    }
    @Override
    protected String doInBackground(String... voids) {
        StringBuilder response = new StringBuilder();


        try {
            String width = URLEncoder.encode(voids[0], "UTF-8");
            String height = URLEncoder.encode(voids[1], "UTF-8");
            //Link
            String link = urlStr +"?width="+width+"&height="+height;

            //truyền tham số vào url
            URL url = new URL(link);

            //kết nối
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                //đọc dữ liệu
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while((line = reader.readLine()) !=null){
                    response.append(line);
                }
            Log.i("CHECK RESULT", response.toString());
                reader.close();
                connection.disconnect();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return response.toString();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Sending...");
        dialog.show();
    }

    @Override
    protected void onPostExecute(String unused) {
        super.onPostExecute(unused);
        if(unused!=null){
            dialog.dismiss();
            tvResult.setText(unused);
        }
    }
}

//PORT data from 2 Edittext
class PostDataAsyncTask extends AsyncTask<String,Void,String>{
    String urlStr = "http://192.168.15.136:5000/api/lab2/rectangle/post";
    TextView tvResult;
    ProgressDialog dialog;

    public PostDataAsyncTask(Context context, TextView tvResult){
        this.tvResult = tvResult;
        dialog = new ProgressDialog(context);
    }
    @Override
    protected String doInBackground(String... voids) {
        String response = "";
        try {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        //body cho PORT
            String param1 = voids[0];
            String param2 = voids[1];
            String postData = "width="+param1+"&height="+param2;
        //gửi dữ liệu PORT
            byte[] postDataBytes = postData.getBytes(StandardCharsets.UTF_8);

            connection.getOutputStream().write(postDataBytes);

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line ;
                while((line = reader.readLine())!=null){
                    response +=line;
                }
                reader.close();
                connection.disconnect();

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Calculating...");
        dialog.show();
    }

    @Override
    protected void onPostExecute(String unused) {
        super.onPostExecute(unused);
        if(unused!=null){
            dialog.dismiss();
            tvResult.setText(unused);
        }
    }
}