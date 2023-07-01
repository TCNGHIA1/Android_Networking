package com.example.networking.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.networking.R;
import com.example.networking.untils.ImageListener;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncActivity extends AppCompatActivity implements ImageListener{
    private Button btnLoad;
    private ImageView img;
    private TextView msg;
    public static final String URL = "https://res.cloudinary.com/dg1nlrihe/image/upload/v1686218622/PorterAnime/porter_Youkoso.Jitsuryoku.Shijou.Shugi.no.Kyoushitsu.e_vhu2gn.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);

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

    private void clickLoadImage(View v) {
        new LoadImageAsyncTask(this,this).execute(URL);
    }

    @Override
    public void OnImageLoaded(Bitmap bitmap) {
        img.setImageBitmap(bitmap);
        msg.setText("Downloaded image");
    }

    @Override
    public void OnError() {
        msg.setText("Error download Image");
    }

}
class LoadImageAsyncTask extends AsyncTask<String,Void, Bitmap>{
    private ImageListener mListener;
    private ProgressDialog progressDialog;

    private InputStream inputStream;

    public LoadImageAsyncTask(ImageListener listener, Context context){
        this.mListener = listener;
        progressDialog = new ProgressDialog(context);
    }
    @Override
    protected Bitmap doInBackground(String... strings) {
        try{
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            inputStream = connection.getInputStream();
            return BitmapFactory.decodeStream(inputStream);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Dowloading image...");
        progressDialog.show();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        try {
            inputStream.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        if(progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if(bitmap!=null){
            mListener.OnImageLoaded(bitmap);
        }else{
            mListener.OnError();
        }
    }
}