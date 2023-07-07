package com.example.networking.untils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadBitMap {
    public static Bitmap setBitMap(String link){
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
}
