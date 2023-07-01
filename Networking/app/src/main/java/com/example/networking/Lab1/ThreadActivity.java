package com.example.networking.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.networking.R;
import com.example.networking.untils.ImageListener;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ThreadActivity extends AppCompatActivity implements ImageListener {
    private Button btnLoad;
    private ImageView img;
    private TextView msg;

    private ImageListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        btnLoad = findViewById(R.id.btn_load_image);
        img = findViewById(R.id.img);
        msg = findViewById(R.id.msg);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLoadImage(v);
            }
        });
    }

    //load image from server
    private Bitmap loadImage(String link){
        URL url;
        Bitmap bmp = null;
        try{
            url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            bmp = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return bmp;
    }

    //click button load image
    private void clickLoadImage(View view){
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap =  loadImage("https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218622/PorterAnime/porter_Youkoso.Jitsuryoku.Shijou.Shugi.no.Kyoushitsu.e_vhu2gn.jpg");
                img.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("Check",bitmap.getWidth() + " " + bitmap.getHeight());
                        if (bitmap != null && bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            img.setScaleType(ImageView.ScaleType.FIT_XY);
                            img.setImageBitmap(bitmap);
                            msg.setText("Image Dowloaded");
                        }
                    }
                });
            }
        });
        myThread.start();
    }

    @Override
    public void OnImageLoaded(Bitmap bitmap) {

    }

    @Override
    public void OnError() {

    }
}